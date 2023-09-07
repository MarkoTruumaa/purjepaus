package com.example.purjepaus.validation;

import com.example.purjepaus.domain.user.User;
import com.example.purjepaus.infrastructure.exception.BusinessException;

import java.util.Optional;

import static com.example.purjepaus.validation.Error.*;

public class ValidationService {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(
                    INCORRECT_CREDENTIALS.getErrorMessage(),
                    INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }
}