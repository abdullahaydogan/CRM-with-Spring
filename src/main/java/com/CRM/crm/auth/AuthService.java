package com.CRM.crm.auth;

import com.CRM.crm.auth.exception.AuthenticationException;
import com.CRM.crm.auth.token.Token;
import com.CRM.crm.auth.token.TokenService;
import com.CRM.crm.auth.dto.AuthResponse;
import com.CRM.crm.auth.dto.Credentials;
import com.CRM.crm.user.User;
import com.CRM.crm.user.UserService;
import com.CRM.crm.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class AuthService {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    User user;

    public AuthResponse authenticate(Credentials credentials) {
        User inDB = userService.findByUserEmail(credentials.userEmail());
        if (inDB == null) throw new AuthenticationException();
        if (!Objects.equals(credentials.userPassword(), inDB.getUserPassword())) throw new AuthenticationException();
        Token token = tokenService.createToken(inDB, credentials);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setUserDTO(new UserDTO(inDB));
        return authResponse;
    }


}
