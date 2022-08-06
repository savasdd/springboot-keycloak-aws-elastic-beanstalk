package com.aws.sekreterya.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "SEKRETERYA_GROUP")
public class SekreteryaGroup {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "AD")
    private String ad;

    @Column(name = "ACIKLAMA")
    private String aciklama;

    @Version
    @Column(name = "VERSION")
    private Long version;

}
