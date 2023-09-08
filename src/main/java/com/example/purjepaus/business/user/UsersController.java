package com.example.purjepaus.business.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private UsersService usersService;

    @PostMapping("/user")
    public void addNewUser(@RequestBody NewUserInfo newUserInfo) {
        usersService.addNewUser(newUserInfo);
    }
}
