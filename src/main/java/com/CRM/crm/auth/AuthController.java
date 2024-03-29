package com.CRM.crm.auth;

import com.CRM.crm.auth.dto.AuthResponse;
import com.CRM.crm.auth.dto.Credentials;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("api/v1/auth")
    AuthResponse handleAuthentication(@Valid @RequestBody Credentials credentials) {
        return authService.authenticate(credentials);
    }


}
