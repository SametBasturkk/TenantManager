package com.tenantmanager.controller;

import com.tenantmanager.service.HouseServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HouseController {


    HouseServiceImpl houseService;

    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }


    @PostMapping ("/create-house")
    public void createHouse(@RequestParam String ownerId, String houseType, String houseAddress, String housePrice, String houseRooms, String apartmentId) {
        houseService.createHouse(ownerId, houseType, houseAddress, housePrice, houseRooms, apartmentId);
    }


}
