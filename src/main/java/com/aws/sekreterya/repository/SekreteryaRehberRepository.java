package com.aws.sekreterya.repository;

import com.aws.sekreterya.model.SekreteryaRehber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SekreteryaRehberRepository extends JpaRepository<SekreteryaRehber, UUID> {
}
