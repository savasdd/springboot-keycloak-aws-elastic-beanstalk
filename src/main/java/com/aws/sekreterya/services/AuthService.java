package com.aws.sekreterya.services;

import com.aws.sekreterya.services.async.IAuthService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class AuthService {

    private final IAuthService authService;
}
