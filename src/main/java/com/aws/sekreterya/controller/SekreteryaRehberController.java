package com.aws.sekreterya.controller;

import com.aws.sekreterya.model.SekreteryaRehber;
import com.aws.sekreterya.services.SekreteryaRehberService;
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
public class SekreteryaRehberController {

    @Autowired
    private SekreteryaRehberService service;

    @GetMapping("/rehbers")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<List<SekreteryaRehber>> getAllRehber() {
        return new ResponseEntity<>(service.getSekreteryaRehber().getAllRehber(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/rehbers")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaRehber> createRehber(@RequestBody SekreteryaRehber dto) {
        return new ResponseEntity<>(service.getSekreteryaRehber().createRehber(dto), HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/rehbers/{id}")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaRehber> updateRehber(@RequestBody SekreteryaRehber dto, String id) {
        return new ResponseEntity<>(service.getSekreteryaRehber().updateRehber(dto, id), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/rehbers/{id}")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaRehber> deleteRehber(String id) {
        return new ResponseEntity<>(service.getSekreteryaRehber().deleteRehber(id), HttpStatus.OK);
    }
}
