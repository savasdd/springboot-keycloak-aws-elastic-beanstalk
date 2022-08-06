package com.aws.sekreterya.services;

import com.aws.sekreterya.services.async.ISekreteryaIL;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class SekreteryaILService {

    private final ISekreteryaIL il;
}
