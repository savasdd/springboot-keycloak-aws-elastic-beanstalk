package com.aws.sekreterya.services.async;

import com.aws.sekreterya.model.SekreteryaIL;

import java.util.List;

public interface ISekreteryaIL {

    public List<SekreteryaIL> getAllIL();

    public SekreteryaIL getILById(Long id);
}
