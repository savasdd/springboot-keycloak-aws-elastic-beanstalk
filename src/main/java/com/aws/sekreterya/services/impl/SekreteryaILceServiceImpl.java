package com.aws.sekreterya.services.impl;

import com.aws.sekreterya.model.SekreteryaILce;
import com.aws.sekreterya.repository.SekreteryaILceRepository;
import com.aws.sekreterya.services.async.ISekreteryaILce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SekreteryaILceServiceImpl implements ISekreteryaILce {

    private final SekreteryaILceRepository repository;

    @Override
    public List<SekreteryaILce> getAllILce() {
        return repository.findAll();
    }

    @Override
    public SekreteryaILce getILceById(Long id) {
        return repository.findById(id).get();
    }
}
