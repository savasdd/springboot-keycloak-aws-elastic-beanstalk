package com.aws.sekreterya.controller;

import com.aws.sekreterya.model.SekreteryaKod;
import com.aws.sekreterya.services.SekreteryaKodService;
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
public class SekreteryaKodController {

    @Autowired
    private SekreteryaKodService service;

    @GetMapping("/kods")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<List<SekreteryaKod>> getAllRehber() {
        return new ResponseEntity<>(service.getSekreteryaKod().getAllKod(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/kods")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaKod> createKod(@RequestBody SekreteryaKod kod) {
        return new ResponseEntity<>(service.getSekreteryaKod().createKod(kod), HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/kods/{id}")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaKod> updateKod(@RequestBody SekreteryaKod kod, @PathVariable Long id) {
        return new ResponseEntity<>(service.getSekreteryaKod().updateKod(kod, id), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/kods/{id}")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaKod> deleteKod(@PathVariable Long id) {
        return new ResponseEntity<>(service.getSekreteryaKod().deleteKod(id), HttpStatus.OK);
    }
}
