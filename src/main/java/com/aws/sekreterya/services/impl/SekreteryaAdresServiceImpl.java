package com.aws.sekreterya.services.impl;

import com.aws.sekreterya.model.SekreteryaAdres;
import com.aws.sekreterya.repository.SekreteryaAdresRepository;
import com.aws.sekreterya.services.*;
import com.aws.sekreterya.services.async.ISekreteryaAdres;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SekreteryaAdresServiceImpl implements ISekreteryaAdres {
    private final SekreteryaAdresRepository repository;
    private final SekreteryaRehberService rehberService;
    private final SekreteryaKodService kodService;
    private final SekreteryaUlkeService ulkeService;
    private final SekreteryaILService ilService;
    private final SekreteryaILceService ilceService;


    @Override
    public List<SekreteryaAdres> getAllAdres() {
        var list = repository.findAll();
        log.info("Adres GetAll " + list.size());
        return list;
    }

    @Override
    public SekreteryaAdres createAdres(SekreteryaAdres dto) {
        dto.setVersion(0L);
        dto.setRehber(dto.getRehber().getId() != null ? rehberService.getSekreteryaRehber().getRehberById(dto.getRehber().getId().toString()) : null);
        dto.setTip(dto.getTip().getId() != null ? kodService.getSekreteryaKod().getKodById(dto.getTip().getId()).get() : null);
        dto.setUlke(dto.getUlke().getId() != null ? ulkeService.getUlke().getUlkeById(dto.getUlke().getId()) : null);
        dto.setIl(dto.getIl().getId() != null ? ilService.getIl().getILById(dto.getIl().getId()) : null);
        dto.setIlce(dto.getIlce().getId() != null ? ilceService.getIlce().getILceById(dto.getIlce().getId()) : null);
        var newAdres = repository.save(dto);
        log.info("Create Adres");
        return newAdres.getId() != null ? newAdres : null;
    }

    @Override
    public SekreteryaAdres updateAdres(SekreteryaAdres dto, String id) {
        var adres = repository.findById(UUID.fromString(id));
        var updateAdres = adres.map(var -> {
            var.setAdres(dto.getAdres());
            var.setBirincil(dto.getBirincil());
            var.setPostaKodu(dto.getPostaKodu());
            var.setRehber(dto.getRehber().getId() != null ? rehberService.getSekreteryaRehber().getRehberById(dto.getRehber().getId().toString()) : null);
            var.setTip(dto.getTip().getId() != null ? kodService.getSekreteryaKod().getKodById(dto.getTip().getId()).get() : null);
            var.setUlke(dto.getUlke().getId() != null ? ulkeService.getUlke().getUlkeById(dto.getUlke().getId()) : null);
            var.setIl(dto.getIl().getId() != null ? ilService.getIl().getILById(dto.getIl().getId()) : null);
            var.setIlce(dto.getIlce().getId() != null ? ilceService.getIlce().getILceById(dto.getIlce().getId()) : null);
            return var;
        });

        var newAdres = repository.save(updateAdres.get());
        log.info("Update Adres");
        return newAdres.getId() != null ? newAdres : null;
    }

    @Override
    public SekreteryaAdres deleteAdres(String id) {
        var adres = repository.findById(UUID.fromString(id));
        repository.delete(adres.get());
        log.info("Delete Adres");
        return null;
    }
}
