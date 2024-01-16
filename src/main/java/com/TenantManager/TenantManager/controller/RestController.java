package com.TenantManager.TenantManager.controller;

import com.TenantManager.TenantManager.configuration.GsonFactory;
import com.TenantManager.TenantManager.model.OwnerHouse;
import com.TenantManager.TenantManager.service.OwnerService;
import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final OwnerService ownerService;

    private GsonFactory gsonFactory;

    public RestController(OwnerService ownerService, GsonFactory gsonFactory) {
        this.ownerService = ownerService;
        this.gsonFactory = gsonFactory;
    }

    @PostMapping(value = "/createOwner", consumes = "application/json", produces = "application/json")
    public ResponseEntity createOwner(@RequestBody OwnerHouse ownerHouse) {
        OwnerHouse newOwner = new OwnerHouse();
        newOwner.setOwnerName(ownerHouse.getOwnerName());
        newOwner.setOwnerSurname(ownerHouse.getOwnerSurname());
        newOwner.setOwnerPhone(ownerHouse.getOwnerPhone());
        newOwner.setOwnerMail(ownerHouse.getOwnerMail());
        newOwner.setOwnerHouse(ownerHouse.getOwnerHouse());

        ownerService.addOwner(newOwner);

        return ResponseEntity.ok(newOwner);
    }

    @GetMapping(value = "/getOwner", consumes = "application/json", produces = "application/json")
    public ResponseEntity getOwner(@RequestBody String name) {
        JsonObject request = gsonFactory.gson().fromJson(name, JsonObject.class);
        OwnerHouse owner = ownerService.getOwnerByName(request.get("ownerName").getAsString());
        Optional<String> optionalValue = Optional.ofNullable(owner.getOwnerName());
        if (optionalValue.isPresent()) {
            return ResponseEntity.status(200).body(owner);
        } else {
            return ResponseEntity.status(404).body("Owner not found");
        }
    }
}
