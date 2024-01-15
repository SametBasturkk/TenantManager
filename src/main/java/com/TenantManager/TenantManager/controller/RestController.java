package com.TenantManager.TenantManager.controller;

import com.TenantManager.TenantManager.models.OwnerHouse;
import com.TenantManager.TenantManager.service.GsonFactory;
import com.TenantManager.TenantManager.service.OwnerService;
import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
    newOwner.setOwnerID();
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
    if (owner != null) {
      return ResponseEntity.ok(owner);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
