package com.aws.sekreterya.repository;

import com.aws.sekreterya.model.SekreteryaGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SekreteryaGroupRepository extends JpaRepository<SekreteryaGroup, UUID> {

}
