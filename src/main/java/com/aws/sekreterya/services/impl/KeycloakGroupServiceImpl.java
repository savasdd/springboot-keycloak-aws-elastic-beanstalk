package com.aws.sekreterya.services.impl;

import com.aws.sekreterya.dto.GroupDto;
import com.aws.sekreterya.utils.KeycloakUtils;
import com.aws.sekreterya.services.async.IKeycloakGroupService;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class KeycloakGroupServiceImpl implements IKeycloakGroupService {

    @Autowired
    private KeycloakUtils utils;


    public void createGroup(GroupDto model) throws Exception {
        if (model.getName() == null)
            throw new Exception("Grup Adı Zorunlu!");
        GroupRepresentation dto = new GroupRepresentation();
        dto.setName(model.getName());
        utils.initKeycloak().groups().add(dto);
        log.info("Group Created: " + model.getName());
    }

    public GroupRepresentation findGroupByName(String id) {
        log.info("FindGroupById");
        return utils.initKeycloak().groups().group(id).toRepresentation();
    }

    public void deleteGroup(String id) {
        log.info("Group Deleted: " + id);
        utils.initKeycloak().groups().group(id).remove();
    }

    public List<GroupRepresentation> findAllGroup() {
        List<GroupRepresentation> list = utils.initKeycloak().groups().groups();
        return list;
    }

    public List<UserRepresentation> usersOfGroup(String id) {
        log.info("UsersOfGroup");
        List<UserRepresentation> list = utils.initKeycloak().groups().group(id).members();
        return list;
    }

    public void rolAddGroup(String groupId, String rolAdi) {
        log.info("Group RolAddGroup: " + groupId);
        RoleRepresentation rol = utils.initKeycloak().roles().get(rolAdi).toRepresentation();
        utils.initKeycloak().groups().group(groupId).roles().realmLevel().add(Arrays.asList(rol));
    }

    public List<RoleRepresentation> rolsOfGroup(String id) {
        log.info("RolsOfGroup");
        List<RoleRepresentation> list = utils.initKeycloak().groups().group(id).roles().realmLevel().listAll();
        return list;
    }


}
