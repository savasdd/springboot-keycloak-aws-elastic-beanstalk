package com.aws.sekreterya.services.impl;

import com.aws.sekreterya.model.SekreteryaGroup;
import com.aws.sekreterya.repository.SekreteryaGroupRepository;
import com.aws.sekreterya.services.async.ISekreteryaGroup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SekreteryaGroupServiceImpl implements ISekreteryaGroup {

    private final SekreteryaGroupRepository repository;

    @Override
    public List<SekreteryaGroup> getAllGroup() {
        var list = repository.findAll();
        log.info("SekreteryaGroup GetAll: " + list.size());
        return list;
    }

    @Override
    public Optional<SekreteryaGroup> getGroupById(String id) {
        return repository.findById(UUID.fromString(id));
    }

    @Override
    public SekreteryaGroup createGroup(SekreteryaGroup dto) {
        dto.setVersion(0L);
        var group = repository.save(dto);
        log.info("Create Group");
        return group.getId() != null ? group : null;
    }

    @Override
    public SekreteryaGroup updateGroup(SekreteryaGroup dto, String id) {
        var groups = repository.findById(UUID.fromString(id));
        var upateGroup = groups.map(val -> {
            val.setAd(dto.getAd());
            val.setAciklama(dto.getAciklama());
            return val;
        });

        var newGroup = repository.save(upateGroup.get());
        log.info("Update Group");
        return newGroup;
    }

    @Override
    public SekreteryaGroup deleteGroup(String id) {
        var dto = repository.findById(UUID.fromString(id));
        repository.delete(dto.get());
        log.info("Delete Group");
        return dto.get();
    }
}
