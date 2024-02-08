package com.tenantmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EstateAgentDTO {
    @NotBlank(message = "Estate agent name cannot be blank")
    private String estateAgentName;

    @NotBlank(message = "Estate agent surname cannot be blank")
    private String estateAgentSurname;

    @NotBlank(message = "Estate agent phone cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String estateAgentPhone;

    @NotBlank(message = "Estate agent mail cannot be blank")
    @Pattern(regexp = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String estateAgentMail;

    @NotBlank(message = "Estate agent TCKN cannot be blank")
    @Size(min = 11, max = 11, message = "TCKN must be 11 characters")
    @Pattern(regexp = "\\d{11}", message = "TCKN must be numeric")
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

    public String getEstateAgentTCKN() {
        return estateAgentTCKN;
    }

    public void setEstateAgentTCKN(String estateAgentTCKN) {
        this.estateAgentTCKN = estateAgentTCKN;
    }
}
