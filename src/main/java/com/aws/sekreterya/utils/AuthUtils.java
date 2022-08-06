package com.aws.sekreterya.utils;

import com.aws.sekreterya.dto.UserCustomDto;
import lombok.ToString;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@ToString
public class AuthUtils {


    public UserCustomDto getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal principal = (KeycloakPrincipal) auth.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken access = session.getToken();

        return new UserCustomDto(access.getGivenName(), access.getFamilyName(), access.getPreferredUsername(), access.getEmail(), access.getIssuer());
    }

}
