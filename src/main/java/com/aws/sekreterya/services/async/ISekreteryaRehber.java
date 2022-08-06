package com.aws.sekreterya.services.async;

import com.aws.sekreterya.model.SekreteryaRehber;

import java.util.List;

public interface ISekreteryaRehber {

    public List<SekreteryaRehber> getAllRehber();
    public SekreteryaRehber getRehberById(String id);

    public SekreteryaRehber createRehber(SekreteryaRehber dto);

    public SekreteryaRehber updateRehber(SekreteryaRehber dto, String id);

    public SekreteryaRehber deleteRehber(String id);
}
