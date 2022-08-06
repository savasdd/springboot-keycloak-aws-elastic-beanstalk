package com.aws.sekreterya.services.async;

import com.aws.sekreterya.model.SekreteryaGroup;

import java.util.List;
import java.util.Optional;

public interface ISekreteryaGroup {

    public List<SekreteryaGroup> getAllGroup();

    public Optional<SekreteryaGroup> getGroupById(String id);

    public SekreteryaGroup createGroup(SekreteryaGroup dto);

    public SekreteryaGroup updateGroup(SekreteryaGroup dto, String id);

    public SekreteryaGroup deleteGroup(String id);
}
