package com.aws.sekreterya.services;

import com.aws.sekreterya.services.async.ISekreteryaAdres;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class SekreteryaAdresService {

    private final ISekreteryaAdres adres;
}
