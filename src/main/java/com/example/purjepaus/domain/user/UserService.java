package com.example.purjepaus.domain.user;

import com.example.purjepaus.business.Status;
import com.example.purjepaus.domain.user.User;
import com.example.purjepaus.domain.user.UserRepository;
import com.example.purjepaus.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password, Status.ACTIVE.getLetter());
        return ValidationService.getValidUser(optionalUser);
    }
}
