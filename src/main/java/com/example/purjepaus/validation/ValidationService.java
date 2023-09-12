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

    public static void validateUsernameAvailability(boolean userNameExists) {
        if (userNameExists) {
            throw new BusinessException(
                    USERNAME_UNAVAILABLE.getErrorMessage(),
                    USERNAME_UNAVAILABLE.getErrorCode());
        }
    }

    public static void validateHarbourNameAvailability(boolean harbourNameExists) {
        if (harbourNameExists) {
            throw new BusinessException(
                    HARBOUR_NAME_UNAVAILABLE.getErrorMessage(),
                    HARBOUR_NAME_UNAVAILABLE.getErrorCode());
        }
    }
}
