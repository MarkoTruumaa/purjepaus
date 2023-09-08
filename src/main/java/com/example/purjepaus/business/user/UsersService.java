package com.example.purjepaus.business.user;

import com.example.purjepaus.domain.user.User;
import com.example.purjepaus.domain.user.UserMapper;
import com.example.purjepaus.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    public void addNewUser(NewUserInfo newUserInfo) {
        String username = newUserInfo.getUsername();
        userService.confirmUsernameAvailability(username);
        User user = new User();
        userMapper.toNewUser(newUserInfo, user);

    }
}
