package com.CRM.crm.auth.token;


import com.CRM.crm.auth.dto.Credentials;
import com.CRM.crm.user.User;

public interface TokenService {

    public Token createToken(User user, Credentials credentials);

    public User verifyToken(String authorizationHeader);


}
