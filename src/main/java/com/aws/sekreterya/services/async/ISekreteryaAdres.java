package com.aws.sekreterya.services.async;

import com.aws.sekreterya.model.SekreteryaAdres;

import java.util.List;

public interface ISekreteryaAdres {

    public List<SekreteryaAdres> getAllAdres();

    public SekreteryaAdres createAdres(SekreteryaAdres dto);

    public SekreteryaAdres updateAdres(SekreteryaAdres dto, String id);

    public SekreteryaAdres deleteAdres(String id);
}
