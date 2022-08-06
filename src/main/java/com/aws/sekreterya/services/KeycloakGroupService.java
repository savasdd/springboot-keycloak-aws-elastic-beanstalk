package com.aws.sekreterya.services;

import com.aws.sekreterya.services.async.IKeycloakGroupService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class KeycloakGroupService {

    private final IKeycloakGroupService groupService;
}
