package com.aws.sekreterya.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SEKRETERYA_ULKE")
public class SekreteryaUlke {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GNL_GEN")
    @SequenceGenerator(name = "GNL_GEN", sequenceName = "SEKRETERYA_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TANIM")
    private String tanim;

    @Column(name = "ACIKLAMA")
    private String aciklama;

    @Version
    @Column(name = "VERSION")
    private Long version;


}
