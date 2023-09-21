package com.example.purjepaus.domain.user;

import com.example.purjepaus.business.Status;
import com.example.purjepaus.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User confirmUsernameAvailability(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password, Status.ACTIVE.getLetter());
        return ValidationService.getValidUser(optionalUser);
    }

    public void confirmUsernameAvailability(String username) {
        boolean usernameExists = userRepository.usernameExistsBy(username);
        ValidationService.validateUsernameAvailability(usernameExists);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserBy(Integer userId) {
        return userRepository.getReferenceById(userId);
    }

    public void checkUserBy(Integer userId, String password) {
        boolean userExists = userRepository.checkUserBy(userId, password);
        ValidationService.validateUserPassword(userExists);
    }

    public List<User> getCaptainInfo(Boolean isCaptain) {
        return userRepository.findUserBy(isCaptain);
    }
}
