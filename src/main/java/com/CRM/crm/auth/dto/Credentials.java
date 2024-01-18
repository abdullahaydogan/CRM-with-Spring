package com.CRM.crm.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Credentials(@Email String userEmail, @NotBlank String userPassword) {

}
