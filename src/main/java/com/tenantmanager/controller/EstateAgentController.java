package com.tenantmanager.controller;

import com.tenantmanager.dto.EstateAgentDTO;
import com.tenantmanager.exception.DtoModelConvertException;
import com.tenantmanager.model.EstateAgent;
import com.tenantmanager.service.impl.EstateAgentServiceImpl;
import com.tenantmanager.util.DTOConverter;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RateLimiter(name = "simpleRateLimit")
public class EstateAgentController {

    private final EstateAgentServiceImpl estateAgentService;
    private DTOConverter converter;

    private static final Logger logger = LoggerFactory.getLogger(EstateAgentController.class);


    public EstateAgentController(EstateAgentServiceImpl estateAgentService, DTOConverter converter) {
        this.estateAgentService = estateAgentService;
        this.converter = converter;
    }

    @PostMapping("/create-estateagent")
    public ResponseEntity createEstateAgent(@RequestBody @Valid EstateAgent estateAgent) {
        EstateAgentDTO response = converter.estateAgentModelToDto(estateAgentService.createEstateAgent(estateAgent));
        logger.info("EstateAgent created");
        try {
            if (response == null) {
                throw new DtoModelConvertException("EstateAgent not created");
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }
        } catch (DtoModelConvertException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/get-estateagent-by-name-surname")
    public ResponseEntity getEstateAgentByNameAndSurname(@RequestParam String estateAgentName, String estateAgentSurname) {
        logger.info("EstateAgent retrieved");
        return ResponseEntity.status(HttpStatus.OK).body(converter.estateAgentsModelToDto(estateAgentService.getEstateAgentByNameAndSurname(estateAgentName, estateAgentSurname)));
    }

    @GetMapping("/get-estateagent-by-tckn")
    public ResponseEntity getEstateAgentByTCKN(@RequestParam String TCKN) {
        logger.info("EstateAgent retrieved");
        EstateAgentDTO response = converter.estateAgentModelToDto(estateAgentService.getEstateAgentByTCKN(TCKN));
        try {
            if (response == null) {
                throw new DtoModelConvertException("EstateAgent not found");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (DtoModelConvertException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    public ResponseEntity fallback(Exception e) {
        logger.error("Too many requests");
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }
}
