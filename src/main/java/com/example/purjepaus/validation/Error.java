package com.example.purjepaus.validation;

import lombok.Getter;

@Getter
public enum Error {

    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    HARBOUR_NAME_UNAVAILABLE("Sellise nimega sadam on süsteemis juba olemas", 222),
    USERNAME_UNAVAILABLE("Sellise nimega kasutaja on süsteemis juba olemas", 333),
    INCORRECT_PASSWORD("Vana parool vale", 444)

    ;


    private final String errorMessage;
    private final int errorCode;

    Error(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
