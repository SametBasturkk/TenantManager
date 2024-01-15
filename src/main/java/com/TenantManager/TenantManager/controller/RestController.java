package com.TenantManager.TenantManager.controller;

import com.TenantManager.TenantManager.models.OwnerHouse;
import com.TenantManager.TenantManager.service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class RestController {

  //Autowire
  private final OwnerService ownerService;

  public RestController(OwnerService ownerService) {
    this.ownerService = ownerService;
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
  public ResponseEntity getOwner(@RequestBody RequestGetOwner ownerName) {
    OwnerHouse owner = ownerService.getOwnerByName(ownerName.getOwnerName());
    if (owner != null) {
      return ResponseEntity.ok(owner);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
