package com.example.purjepaus.business.user;

import com.example.purjepaus.business.user.dto.NewUser;
import com.example.purjepaus.business.user.dto.UserInfo;
import com.example.purjepaus.domain.user.role.RoleService;
import com.example.purjepaus.domain.user.*;
import com.example.purjepaus.domain.user.contact.Contact;
import com.example.purjepaus.domain.user.contact.ContactMapper;
import com.example.purjepaus.domain.user.contact.ContactService;
import com.example.purjepaus.domain.user.role.Role;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
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


    public void addNewUser(NewUser newUser) {
        checkUsernameAvailability(newUser);
        Contact contact = creatAndSaveContact(newUser);
        Role role = roleService.getRoleBy(newUser.getRoleName());
        createAndSaveUser(newUser, contact, role);

    }

    private void checkUsernameAvailability(NewUser newUser) {
        String username = newUser.getUsername();
        userService.confirmUsernameAvailability(username);
    }

    private Contact creatAndSaveContact(NewUser newUser) {
        Contact contact = contactMapper.toContact(newUser);
        contactService.saveContact(contact);
        return contact;
    }

    private void createAndSaveUser(NewUser newUser, Contact contact, Role role) {
        User user = userMapper.toUser(newUser);
        user.setContact(contact);
        user.setRole(role);
        userService.saveUser(user);
    }

    @Transactional
    public void updateUserInfo(Integer userId, UserInfo userInfo) {
        User user = userService.getUserBy(userId);
        user.setUsername(userInfo.getUsername());
        userService.saveUser(user);

        Contact contact = user.getContact();
        contactMapper.partialUpdate(userInfo, contact);
        contactService.saveContact(contact);
    }
}
