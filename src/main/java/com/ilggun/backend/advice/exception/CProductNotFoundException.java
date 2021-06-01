package com.ilggun.backend.advice.exception;

public class CProductNotFoundException extends RuntimeException{
    public CProductNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public CProductNotFoundException(String msg) {
        super(msg);
    }

    public CProductNotFoundException() {
        super();
    }
}
