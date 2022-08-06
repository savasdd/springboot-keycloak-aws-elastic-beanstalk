package com.aws.sekreterya.services.impl;

import com.aws.sekreterya.dto.UserDto;
import com.aws.sekreterya.utils.KeycloakUtils;
import com.aws.sekreterya.services.async.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private KeycloakUtils utils;

    @Override
    public Map<String, String> authToken(UserDto dto) {
        Map<String, String> token = new HashMap<>();
        Keycloak keycloak = utils.initKeycloak(dto);
        AccessTokenResponse response = keycloak.tokenManager().getAccessToken();
        token.put("type", response.getTokenType());
        token.put("access", response.getToken());
        log.info("Generated Token: " + dto.getUsername());
        return token;
    }
}
