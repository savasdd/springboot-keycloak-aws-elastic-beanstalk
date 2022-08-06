package com.aws.sekreterya.services.async;

import com.aws.sekreterya.model.SekreteryaUlke;

import java.util.List;

public interface ISekreteryaUlke {

    public List<SekreteryaUlke> getAllUlke();

    public SekreteryaUlke getUlkeById(Long id);
}
