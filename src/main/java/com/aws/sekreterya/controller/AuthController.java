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
}
