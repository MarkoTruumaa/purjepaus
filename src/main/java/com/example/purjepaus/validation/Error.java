package com.example.purjepaus.validation;

import lombok.Getter;

@Getter
public enum Error {

    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    USERNAME_UNAVAILABLE("Sellise nimega kasutaja on süsteemis juba olemas", 333)
    ;


    private final String errorMessage;
    private final int errorCode;

    Error(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
