package com.aws.sekreterya.controller;

import com.aws.sekreterya.model.SekreteryaAdres;
import com.aws.sekreterya.services.SekreteryaAdresService;
import com.aws.sekreterya.utils.SekreteryaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class SekreteryaAdresController {

    @Autowired
    private SekreteryaAdresService service;

    @GetMapping("/rehbers/adres")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<List<SekreteryaAdres>> getAllAdres() {
        return new ResponseEntity<>(service.getAdres().getAllAdres(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/rehbers/adres")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaAdres> createAdres(@RequestBody SekreteryaAdres dto) {
        return new ResponseEntity<>(service.getAdres().createAdres(dto), HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/rehbers/adres/{id}")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaAdres> updateAdres(@RequestBody SekreteryaAdres dto, String id) {
        return new ResponseEntity<>(service.getAdres().updateAdres(dto, id), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/rehbers/adres/{id}")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaAdres> deleteAdres(String id) {
        return new ResponseEntity<>(service.getAdres().deleteAdres(id), HttpStatus.OK);
    }
}
