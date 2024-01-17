package com.TenantManager.TenantManager.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

@Entity(name = "owner")

public class OwnerDAO {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private UUID ownerID;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String ownerSurname;

    @Column(nullable = false)
    private String ownerPhone;

    @Column(nullable = false)
    private String ownerMail;

    @Column(nullable = false)
    private String ownerHouse;

    @Column(nullable = false)
    private String ownerTCKN;

    private Date createdAt;

    @Column(nullable = false)
    private Date updatedAt;

}
