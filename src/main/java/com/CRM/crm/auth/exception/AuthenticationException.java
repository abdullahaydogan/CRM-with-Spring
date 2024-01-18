package com.CRM.crm.auth.exception;

import com.mysql.cj.Messages;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
        super(Messages.getString("CRM.auth.invalid.credentials "));

    }
}
