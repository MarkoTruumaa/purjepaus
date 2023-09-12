package com.example.purjepaus.business.user;

import com.example.purjepaus.business.user.dto.UserInfo;
import com.example.purjepaus.domain.user.role.RoleService;
import com.example.purjepaus.domain.user.*;
import com.example.purjepaus.domain.user.contact.Contact;
import com.example.purjepaus.domain.user.contact.ContactMapper;
import com.example.purjepaus.domain.user.contact.ContactService;
import com.example.purjepaus.domain.user.role.Role;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ContactMapper contactMapper;
    @Resource
    private ContactService contactService;
    @Resource
    private RoleService roleService;


    public void addNewUser(UserInfo userInfo) {
        String username = userInfo.getUsername();
        userService.confirmUsernameAvailability(username);

        Contact contact = contactMapper.toContact(userInfo);

        contactService.saveContact(contact);

        Role role = roleService.getRoleBy(userInfo.getRoleName());

        User user = userMapper.toUser(userInfo);
        user.setContact(contact);
        user.setRole(role);

        userService.saveUser(user);


    }
}
