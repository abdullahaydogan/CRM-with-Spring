package com.CRM.crm.exception;

import com.mysql.cj.Messages;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
        super(Messages.getString("User cant Activated"));
    }
}
