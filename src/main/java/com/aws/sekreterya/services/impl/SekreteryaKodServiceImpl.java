package com.aws.sekreterya.services.impl;

import com.aws.sekreterya.model.SekreteryaKod;
import com.aws.sekreterya.repository.SekreteryaKodRepository;
import com.aws.sekreterya.services.async.ISekreteryaKod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SekreteryaKodServiceImpl implements ISekreteryaKod {
    private final SekreteryaKodRepository repository;

    @Override
    public List<SekreteryaKod> getAllKod() {
        return repository.findAll();
    }

    @Override
    public Optional<SekreteryaKod> getKodById(Long id) {
        return repository.findById(id);
    }

    @Override
    public SekreteryaKod createKod(SekreteryaKod kod) {
        kod.setVersion(0L);
        var newKod = repository.save(kod);
        log.info("Created Kod");
        if (newKod.getId() != null)
            return newKod;
        else
            return null;
    }

    @Override
    public SekreteryaKod updateKod(SekreteryaKod dto, Long id) {
        var kods = repository.findById(id);
        var upateKod = kods.map(val -> {
            val.setUstId(dto.getUstId());
            val.setKod(dto.getKod());
            val.setAciklama(dto.getAciklama());
            val.setAktif(dto.getAktif());
            val.setSiraNo(dto.getSiraNo());
            val.setTanim(dto.getTanim());
            return val;
        });

        var newKod = repository.save(upateKod.get());
        log.info("Update Kod");
        return newKod;
    }

    @Override
    public SekreteryaKod deleteKod(Long id) {
        var kod = repository.findById(id);
        repository.delete(kod.get());
        log.info("Delete Kod");
        return kod.get();
    }
}
