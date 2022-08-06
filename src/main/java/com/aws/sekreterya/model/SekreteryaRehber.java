package com.aws.sekreterya.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "SEKRETERYA_REHBER")
public class SekreteryaRehber {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "AD")
    private String ad;

    @Column(name = "SOYAD")
    private String soyad;

    @Column(name = "DOGUM_TARIHI")
    @Temporal(TemporalType.DATE)
    private Date dagumTarihi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", nullable = false)
    private SekreteryaGroup group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CINSIYET_ID", referencedColumnName = "ID", nullable = true)
    private SekreteryaKod cinsiyet;

    @Version
    @Column(name = "VERSION")
    private Long version;

}
