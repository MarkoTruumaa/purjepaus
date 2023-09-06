package com.example.purjepaus.business;

import lombok.Getter;

@Getter
public enum Status {

    ACTIVE("A"),
    DELETED("D");

    private final String letter;

    Status(String name) {
        this.letter = name;
    }
}
