package com.aws.sekreterya.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SEKRETERYA_ILCE")
public class SekreteryaILce {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GNL_GEN")
    @SequenceGenerator(name = "GNL_GEN", sequenceName = "SEKRETERYA_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IL_ID", referencedColumnName = "ID", nullable = false)
    private SekreteryaIL il;

    @Column(name = "TANIM")
    private String tanim;

    @Version
    @Column(name = "VERSION")
    private Long version;


}
