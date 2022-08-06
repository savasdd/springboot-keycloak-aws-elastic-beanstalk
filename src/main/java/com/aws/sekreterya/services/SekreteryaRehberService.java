package com.aws.sekreterya.services;

import com.aws.sekreterya.services.async.ISekreteryaRehber;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class SekreteryaRehberService {

    private final ISekreteryaRehber sekreteryaRehber;
}
