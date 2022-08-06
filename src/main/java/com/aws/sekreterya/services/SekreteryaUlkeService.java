package com.aws.sekreterya.services;

import com.aws.sekreterya.services.async.ISekreteryaUlke;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class SekreteryaUlkeService {
    private final ISekreteryaUlke ulke;
}
