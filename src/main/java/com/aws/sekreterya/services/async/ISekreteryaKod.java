package com.aws.sekreterya.services.async;

import com.aws.sekreterya.model.SekreteryaKod;

import java.util.List;
import java.util.Optional;

public interface ISekreteryaKod {
    public List<SekreteryaKod> getAllKod();
    public Optional<SekreteryaKod> getKodById(Long id);
    public SekreteryaKod createKod(SekreteryaKod kod);
    public SekreteryaKod updateKod(SekreteryaKod kod,Long id);
    public SekreteryaKod deleteKod(Long id);
}
