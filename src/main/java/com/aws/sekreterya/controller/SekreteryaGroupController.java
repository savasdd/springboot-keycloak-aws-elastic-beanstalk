package com.aws.sekreterya.controller;

import com.aws.sekreterya.model.SekreteryaGroup;
import com.aws.sekreterya.services.SekreteryaGroupService;
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
public class SekreteryaGroupController {

    @Autowired
    private SekreteryaGroupService service;

    @GetMapping("/groups")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<List<SekreteryaGroup>> getRehber() {
        return new ResponseEntity<>(service.getSekreteryaGroup().getAllGroup(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/groups")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaGroup> createGroup(@RequestBody SekreteryaGroup dto) {
        return new ResponseEntity<>(service.getSekreteryaGroup().createGroup(dto), HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/groups/{id}")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaGroup> updateGroup(@RequestBody SekreteryaGroup dto, String id) {
        return new ResponseEntity<>(service.getSekreteryaGroup().updateGroup(dto, id), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/groups/{id}")
    @RolesAllowed(value = SekreteryaUtils.SEKRETERYA_ROLU)
    public ResponseEntity<SekreteryaGroup> deleteGroup(String id) {
        return new ResponseEntity<>(service.getSekreteryaGroup().deleteGroup(id), HttpStatus.OK);
    }
}
