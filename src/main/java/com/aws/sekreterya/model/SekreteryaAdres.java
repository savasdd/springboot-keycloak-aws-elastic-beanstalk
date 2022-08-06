package com.aws.sekreterya.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "SEKRETERYA_ADRES")
public class SekreteryaAdres {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.Type(type = "pg-uuid")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REHBER_ID", referencedColumnName = "ID", nullable = false)
    private SekreteryaRehber rehber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIP_ID", referencedColumnName = "ID", nullable = true)
    private SekreteryaKod tip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ULKE_ID", referencedColumnName = "ID", nullable = true)
    private SekreteryaUlke ulke;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IL_ID", referencedColumnName = "ID", nullable = true)
    private SekreteryaIL il;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ILCE_ID", referencedColumnName = "ID", nullable = true)
    private SekreteryaILce ilce;

    @Column(name = "ADRES", length = 5000)
    private String adres;

    @Column(name = "POSTA_KODU")
    private String postaKodu;

    @Column(name = "BIRINCIL")
    private Boolean birincil;

    @Version
    @Column(name = "VERSION")
    private Long version;

}
