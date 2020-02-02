package com.codegrasp.demorest.service;

public class CustomChuckException extends Exception {
    public CustomChuckException() {
    }

    public CustomChuckException(String message) {
        super(message);
    }

    public CustomChuckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomChuckException(Throwable cause) {
        super(cause);
    }

    public CustomChuckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
