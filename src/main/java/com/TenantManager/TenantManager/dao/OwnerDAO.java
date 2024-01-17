package com.TenantManager.TenantManager.dao;

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
    private UUID ownerID;
    private String ownerName;
    private String ownerSurname;
    private String ownerPhone;
    private String ownerMail;
    private String ownerHouse;
    private String ownerTCKN;
    private Date createdAt;
    private Date updatedAt;
}
