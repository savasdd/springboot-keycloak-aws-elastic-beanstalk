package com.aws.sekreterya.services.impl;

import com.aws.sekreterya.repository.SekreteryaUlkeRepository;
import com.aws.sekreterya.model.SekreteryaUlke;
import com.aws.sekreterya.services.async.ISekreteryaUlke;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SekreteryaUlkeServiceImpl implements ISekreteryaUlke {
    private final SekreteryaUlkeRepository repository;

    @Override
    public List<SekreteryaUlke> getAllUlke() {
        return repository.findAll();
    }

    @Override
    public SekreteryaUlke getUlkeById(Long id) {
        return repository.findById(id).get();
    }
}
