package com.aws.sekreterya.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "SEKRETERYA_KOD")
public class SekreteryaKod {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GNL_GEN")
    @SequenceGenerator(name = "GNL_GEN", sequenceName = "SEKRETERYA_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "UST_ID")
    private Long ustId;

    @Column(name = "TANIM")
    private String tanim;

    @Column(name = "KOD")
    private String kod;

    @Column(name = "AKTIF")
    private Boolean aktif;

    @Column(name = "SIRA_NO")
    private Long siraNo;

    @Column(name = "ACIKLAMA")
    private String aciklama;

    @Version
    @Column(name = "VERSION")
    private Long version;


}
