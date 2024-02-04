package com.tenantmanager.controller;

import com.tenantmanager.dto.EstateAgentDTO;
import com.tenantmanager.exception.CustomResponseException;
import com.tenantmanager.model.EstateAgent;
import com.tenantmanager.service.EstateAgentServiceImpl;
import com.tenantmanager.util.DTOConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EstateAgentController {

    private final EstateAgentServiceImpl estateAgentService;
    private DTOConverter converter;

    public EstateAgentController(EstateAgentServiceImpl estateAgentService, DTOConverter converter) {
        this.estateAgentService = estateAgentService;
        this.converter = converter;
    }

    @PostMapping("/create-estateagent")
    public ResponseEntity createEstateAgent(@RequestBody EstateAgent estateAgent) {
        EstateAgentDTO response = converter.estateAgentModelToDto(estateAgentService.createEstateAgent(estateAgent));
        try {
            if (response == null) {
                throw new CustomResponseException("EstateAgent not created");
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }
        } catch (CustomResponseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/get-estateagent-by-name-surname")
    public ResponseEntity getEstateAgentByNameAndSurname(@RequestParam String estateAgentName, String estateAgentSurname) {
        List<EstateAgent> estateAgentList = estateAgentService.getEstateAgentByNameAndSurname(estateAgentName, estateAgentSurname);
        List<EstateAgentDTO> responseList = new ArrayList<>();
        for (EstateAgent estateAgent : estateAgentList) {
            responseList.add(converter.estateAgentModelToDto(estateAgent));
        }
        try {
            if (responseList.isEmpty()) {
                throw new CustomResponseException("EstateAgent not found");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(responseList);
            }
        } catch (CustomResponseException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/get-estateagent-by-tckn")
    public ResponseEntity getEstateAgentByTCKN(@RequestParam String TCKN) {
        EstateAgentDTO response = converter.estateAgentModelToDto(estateAgentService.getEstateAgentByTCKN(TCKN));
        try {
            if (response == null) {
                throw new CustomResponseException("EstateAgent not found");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (CustomResponseException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
