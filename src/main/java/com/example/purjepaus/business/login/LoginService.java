package com.example.purjepaus.business.login;

import com.example.purjepaus.business.dtos.LoginResponse;
import com.example.purjepaus.domain.user.UserService;
import com.example.purjepaus.domain.user.User;
import com.example.purjepaus.domain.user.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);
        return userMapper.toLoginResponse(user);
    }
}
