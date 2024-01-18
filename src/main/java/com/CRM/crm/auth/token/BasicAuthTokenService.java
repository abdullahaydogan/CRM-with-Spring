package com.CRM.crm.auth.token;

import com.CRM.crm.auth.dto.Credentials;
import com.CRM.crm.user.User;
import com.CRM.crm.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class BasicAuthTokenService implements TokenService {
    @Autowired
    UserService userService;

    @Override
    public Token createToken(User user, Credentials credentials) {
        String emailColonPassword = credentials.userEmail() + ":" + credentials.userPassword();
        String token = Base64.getEncoder().encodeToString(emailColonPassword.getBytes());
        return new Token("Basic", token);
    }

    @Override
    public User verifyToken(String authorizationHeader) {
        if (authorizationHeader == null) return null;
        var base64Encoded = authorizationHeader.split("Basic")[1];
        var decoded = new String(Base64.getDecoder().decode(base64Encoded));
        var credentials = decoded.split(":");
        var userEmail = credentials[0];
        var userPassword = credentials[1];
        User inDB = userService.findByUserEmail(userEmail);
        if (inDB == null) return null;
        if (inDB.getUserPassword() != userPassword) return null;
        return inDB;
    }
}
