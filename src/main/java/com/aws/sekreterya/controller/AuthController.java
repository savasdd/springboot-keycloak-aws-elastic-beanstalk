package com.aws.sekreterya.controller;

import com.aws.sekreterya.dto.UserDto;
import com.aws.sekreterya.utils.SekreteryaUtils;
import com.aws.sekreterya.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/auth")
    public ResponseEntity<Map<String, String>> authToken(@RequestBody UserDto dto) {
        return new ResponseEntity<>(service.getAuthService().authToken(dto), HttpStatus.OK);
    }

    @GetMapping("/test")
    public void ldapTest() throws NamingException {

        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://enerji.local:389");
//        env.put(Context.SECURITY_PRINCIPAL, "uid=rehber_admin_user, ou=system");
//        env.put(Context.SECURITY_CREDENTIALS, "[C@47dd6e21");
        env.put(Context.SECURITY_PRINCIPAL, "CN=Savaş Dede,OU=Users,OU=Bilgi_Islem,OU=Merkez_Teskilat,OU=ETKB,DC=enerji,DC=local");  //check the DN correctly
        env.put(Context.SECURITY_CREDENTIALS, SekreteryaUtils.PASSWORD);
        env.put(Context.REFERRAL, "follow");
        DirContext con = new InitialDirContext(env);
        System.out.println("success");
        getAllUsers(con);
        con.close();

    }

    public void getAllUsers(DirContext con) throws NamingException {
        String searchFilter = "(objectClass=*)";
        String[] reqAtt = {"cn", "sn", "on"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setCountLimit(3000);
        controls.setReturningAttributes(reqAtt);

        NamingEnumeration users = con.search("CN=Savaş Dede,OU=Users,OU=Bilgi_Islem,OU=Merkez_Teskilat,OU=ETKB,DC=enerji,DC=local", searchFilter, controls);

        SearchResult result = null;
        while (users.hasMore()) {
            result = (SearchResult) users.next();
            Attributes attr = result.getAttributes();
            String name = attr.get("cn").get(0).toString();
            System.out.println(attr.get("cn"));
            System.out.println(attr.get("sn"));
        }

    }
}
