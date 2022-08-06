package com.aws.sekreterya.utils;

import com.aws.sekreterya.dto.UserDto;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeycloakUtils {

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.auth-server-url}")
    private String authUr;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak_username}")
    private String user;

    @Value("${keycloak_password}")
    private String password;

    public RealmResource initKeycloak() {
        RealmResource keycloak = KeycloakBuilder.builder().serverUrl(authUr).grantType(OAuth2Constants.PASSWORD).realm(realm)
                .clientId(clientId).username(user).password(password).build().realm(realm);
        return keycloak;
    }


    public Keycloak initKeycloak(UserDto dto) {
        Keycloak keycloak = KeycloakBuilder.builder().serverUrl(authUr).grantType(OAuth2Constants.PASSWORD).realm(realm)
                .clientId(clientId).username(dto.getUsername()).password(dto.getPassword()).build();
        return keycloak;
    }


}
