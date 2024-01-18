package com.CRM.crm.user.dto;

import com.CRM.crm.user.User;
import jakarta.validation.constraints.NotBlank;

public record UserCreate(
        @NotBlank(message = "crm.constraints.username.notblank ")
        String userName,
        @NotBlank(message = "crm.constraints.password.notblank ")
        // @Size (min = 4,max = 100)
        String userPassword,
        @NotBlank
        String userEmail
) {
    public User toUser() {
        User user = new User();
        user.setEmail(userEmail);
        user.setUserName(userName);
        user.setUserPassword(userPassword());
        return user;
    }

}
