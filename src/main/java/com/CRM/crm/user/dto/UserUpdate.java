package com.CRM.crm.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UserUpdate(
        @NotBlank(message = "crm.constraints.username.notblank ")
        String userName,
        @NotBlank(message = "crm.constraints.password.notblank ")
        // @Size (min = 4,max = 100)
        String userPassword,
        @NotBlank
        String userEmail) {

}
