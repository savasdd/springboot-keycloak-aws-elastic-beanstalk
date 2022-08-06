package com.aws.sekreterya.services;

import com.aws.sekreterya.services.async.ISekreteryaGroup;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class SekreteryaGroupService {

    private final ISekreteryaGroup sekreteryaGroup;
}
