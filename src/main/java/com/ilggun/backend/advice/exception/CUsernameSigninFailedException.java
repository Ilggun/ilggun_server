package com.ilggun.backend.advice.exception;

public class CUsernameSigninFailedException extends RuntimeException {
    public CUsernameSigninFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public CUsernameSigninFailedException(String msg) {
        super(msg);
    }

    public CUsernameSigninFailedException() {
        super();
    }
}
