package com.CRM.crm.auth.dto;

import com.CRM.crm.auth.token.Token;
import com.CRM.crm.user.dto.UserDTO;

public class AuthResponse {
    UserDTO userDTO;
    Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
