package com.aws.sekreterya.services.impl;

import com.aws.sekreterya.model.SekreteryaRehber;
import com.aws.sekreterya.repository.SekreteryaRehberRepository;
import com.aws.sekreterya.services.SekreteryaGroupService;
import com.aws.sekreterya.services.SekreteryaKodService;
import com.aws.sekreterya.services.async.ISekreteryaRehber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SekreteryaRehberServiceImpl implements ISekreteryaRehber {

    private final SekreteryaRehberRepository repository;
    private final SekreteryaGroupService groupService;
    private final SekreteryaKodService kodService;

    @Override
    public List<SekreteryaRehber> getAllRehber() {
        var list = repository.findAll();
        log.info("GetAll Rehber" + list.size());
        return list;
    }

    @Override
    public SekreteryaRehber getRehberById(String id) {
        return repository.findById(UUID.fromString(id)).get();
    }

    @Override
    public SekreteryaRehber createRehber(SekreteryaRehber dto) {
        dto.setVersion(0L);
        dto.setGroup(dto.getGroup().getId() != null ? groupService.getSekreteryaGroup().getGroupById(dto.getGroup().getId().toString()).get() : null);
        dto.setCinsiyet(dto.getCinsiyet().getId() != null ? kodService.getSekreteryaKod().getKodById(dto.getCinsiyet().getId()).get() : null);
        var newRehber = repository.save(dto);
        log.info("Create Rehber");
        return newRehber.getId() != null ? newRehber : null;
    }

    @Override
    public SekreteryaRehber updateRehber(SekreteryaRehber dto, String id) {
        var rehbers = repository.findById(UUID.fromString(id));
        var updateRehber = rehbers.map(val -> {
            val.setAd(dto.getAd());
            val.setSoyad(dto.getSoyad());
            val.setDagumTarihi(dto.getDagumTarihi());
            val.setGroup(dto.getGroup().getId() != null ? groupService.getSekreteryaGroup().getGroupById(dto.getGroup().getId().toString()).get() : val.getGroup());
            val.setCinsiyet(dto.getCinsiyet().getId() != null ? kodService.getSekreteryaKod().getKodById(dto.getCinsiyet().getId()).get() : val.getCinsiyet());
            return val;
        });
        var newRehber = repository.save(updateRehber.get());
        log.info("Update Rehber");
        return newRehber.getId() != null ? newRehber : null;
    }

    @Override
    public SekreteryaRehber deleteRehber(String id) {
        var rehber = repository.findById(UUID.fromString(id));
        repository.delete(rehber.get());
        log.info("Delete Rehber");
        return rehber.get();
    }
}
