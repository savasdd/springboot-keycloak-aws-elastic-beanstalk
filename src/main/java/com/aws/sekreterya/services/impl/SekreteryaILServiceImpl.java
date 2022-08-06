package com.aws.sekreterya.services.impl;

import com.aws.sekreterya.model.SekreteryaIL;
import com.aws.sekreterya.services.async.ISekreteryaIL;
import com.aws.sekreterya.repository.SekreteryaILRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SekreteryaILServiceImpl implements ISekreteryaIL {

    private final SekreteryaILRepository repository;

    @Override
    public List<SekreteryaIL> getAllIL() {
        return repository.findAll();
    }

    @Override
    public SekreteryaIL getILById(Long id) {
        return repository.findById(id).get();
    }
}
