package com.aws.sekreterya.services.async;

import com.aws.sekreterya.model.SekreteryaILce;

import java.util.List;

public interface ISekreteryaILce {

    public List<SekreteryaILce> getAllILce();

    public SekreteryaILce getILceById(Long id);
}
