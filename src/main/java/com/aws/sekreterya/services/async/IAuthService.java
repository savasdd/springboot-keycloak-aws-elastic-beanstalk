package com.aws.sekreterya.services.async;

import com.aws.sekreterya.dto.UserDto;

import java.util.Map;

public interface IAuthService {

    public Map<String, String> authToken(UserDto dto);
}
