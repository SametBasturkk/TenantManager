package com.TenantManager.TenantManager.controller;

import com.TenantManager.TenantManager.configuration.GsonFactory;
import com.TenantManager.TenantManager.dto.OwnerDTO;
import com.TenantManager.TenantManager.model.Owner;
import com.TenantManager.TenantManager.service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final OwnerService ownerService;

    private GsonFactory gsonFactory;

    public RestController(OwnerService ownerService, GsonFactory gsonFactory) {
        this.ownerService = ownerService;
        this.gsonFactory = gsonFactory;
    }

    @PostMapping("/create-owner")
    public ResponseEntity createOwner(@RequestBody Owner owner) {
        Owner newOwner = new Owner();
        newOwner.setOwnerName(owner.getOwnerName());
        newOwner.setOwnerSurname(owner.getOwnerSurname());
        newOwner.setOwnerPhone(owner.getOwnerPhone());
        newOwner.setOwnerMail(owner.getOwnerMail());
        newOwner.setOwnerHouse(owner.getOwnerHouse());
        newOwner.setOwnerTCKN(owner.getOwnerTCKN());

        ownerService.addOwner(newOwner);

        return ResponseEntity.ok(newOwner);
    }

    @GetMapping("/get-owner-by-name-surname")
    public ResponseEntity getOwnerByNameAndSurname(@RequestParam String ownerName, String ownerSurname) {
        OwnerDTO response =
                gsonFactory.gson().fromJson(gsonFactory.gson().toJson(ownerService.getOwnerByNameAndSurname(ownerName,ownerSurname)), OwnerDTO.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-owner-by-tckn")
    public ResponseEntity getOwnerByTCKN(@RequestParam String TCKN) {
        OwnerDTO response =
                gsonFactory.gson().fromJson(gsonFactory.gson().toJson(ownerService.getOwnerByTCKN(TCKN)), OwnerDTO.class);
        return ResponseEntity.ok(response);
    }
}
