package com.aws.sekreterya.services;

import com.aws.sekreterya.services.async.ISekreteryaILce;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class SekreteryaILceService {

    private final ISekreteryaILce ilce;
}
