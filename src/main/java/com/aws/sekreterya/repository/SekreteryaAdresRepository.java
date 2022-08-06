package com.aws.sekreterya.repository;

import com.aws.sekreterya.model.SekreteryaAdres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SekreteryaAdresRepository extends JpaRepository<SekreteryaAdres, UUID> {
}
