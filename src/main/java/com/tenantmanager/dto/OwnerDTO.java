package com.tenantmanager.dto;

import com.tenantmanager.model.House;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

import static com.tenantmanager.util.Validator.*;

public class OwnerDTO {

    @NotBlank(message = "Owner name cannot be blank")
    private String ownerName;

    @NotBlank(message = "Owner surname cannot be blank")
    private String ownerSurname;

    @NotBlank(message = "Owner phone cannot be blank")
    @Pattern(regexp = PHONE_NUMBER_REGEX, message = "Phone number must be 10 digits")
    private String ownerPhone;

    @NotBlank(message = "Owner mail cannot be blank")
    @Pattern(regexp = EMAIL_REGEX, message = "Invalid email format")
    private String ownerMail;

    private List<House> ownerHouse;

    @NotBlank(message = "Owner TCKN cannot be blank")
    @Size(min = 11, max = 11, message = "TCKN must be 11 characters")
    @Pattern(regexp = TCKN_REGEX, message = "TCKN must be numeric")
    private String ownerTCKN;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) {
        this.ownerMail = ownerMail;
    }


    public String getOwnerTCKN() {
        return ownerTCKN;
    }

    public void setOwnerTCKN(String ownerTCKN) {
        this.ownerTCKN = ownerTCKN;
    }


    public List<House> getOwnerHouse() {
        return ownerHouse;
    }

    public void setOwnerHouse(List<House> ownerHouse) {
        this.ownerHouse = ownerHouse;
    }
}
