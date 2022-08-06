package com.aws.sekreterya.services;

import com.aws.sekreterya.services.async.ISekreteryaKod;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class SekreteryaKodService {

    private final ISekreteryaKod sekreteryaKod;
}
