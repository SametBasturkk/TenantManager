package com.tenantmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Table(name = "estate_agents")
@Validated
public class EstateAgent {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String estateAgentName;

    @Column(nullable = false)
    private String estateAgentSurname;

    @Column(nullable = false)
    private String estateAgentPhone;

    @Column(nullable = false)
    @Email
    private String estateAgentMail;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<RentContract> rentContracts;


    @Column(nullable = false, unique = true, name = "estate_agent_TCKN")
    private String estateAgentTCKN;

    public String getEstateAgentName() {
        return estateAgentName;
    }

    public void setEstateAgentName(String estateAgentName) {
        this.estateAgentName = estateAgentName;
    }

    public String getEstateAgentSurname() {
        return estateAgentSurname;
    }

    public void setEstateAgentSurname(String estateAgentSurname) {
        this.estateAgentSurname = estateAgentSurname;
    }

    public String getEstateAgentPhone() {
        return estateAgentPhone;
    }

    public void setEstateAgentPhone(String estateAgentPhone) {
        this.estateAgentPhone = estateAgentPhone;
    }

    public String getEstateAgentMail() {
        return estateAgentMail;
    }

    public void setEstateAgentMail(String estateAgentMail) {
        this.estateAgentMail = estateAgentMail;
    }

    public List<RentContract> getRentContracts() {
        return rentContracts;
    }

    public void setRentContracts(List<RentContract> rentContracts) {
        this.rentContracts = rentContracts;
    }

    public String getEstateAgentTCKN() {
        return estateAgentTCKN;
    }

    public void setEstateAgentTCKN(String estateAgentTCKN) {
        this.estateAgentTCKN = estateAgentTCKN;
    }
}
