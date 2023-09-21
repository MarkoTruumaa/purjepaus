package com.example.purjepaus.business.user;

import com.example.purjepaus.business.user.dto.CaptainInfo;
import com.example.purjepaus.business.user.dto.NewUser;
import com.example.purjepaus.business.user.dto.UserInfo;
import com.example.purjepaus.domain.user.role.RoleService;
import com.example.purjepaus.domain.user.*;
import com.example.purjepaus.domain.user.contact.Contact;
import com.example.purjepaus.domain.user.contact.ContactMapper;
import com.example.purjepaus.domain.user.contact.ContactService;
import com.example.purjepaus.domain.user.role.Role;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.purjepaus.business.Status.DELETED;

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

    public void updateUserInfo(Integer userId, UserInfo userInfo) {
        User user = userService.getUserBy(userId);
        Contact contact = user.getContact();
        contactMapper.partialUpdate(userInfo, contact);
        contactService.saveContact(contact);
    }

    public UserInfo getUserInfo(Integer userId) {
        User user = userService.getUserBy(userId);
        return userMapper.toUserInfo(user);
    }

    public void checkUserPassword(Integer userId, String password) {
        userService.checkUserBy(userId, password);
    }

    public void updateUserPassword(Integer userId, String newPassword) {
        User user = userService.getUserBy(userId);
        user.setPassword(newPassword);
        userService.saveUser(user);
    }

    public void deleteUser(Integer userId) {
        User user = userService.getUserBy(userId);
        user.setStatus(DELETED.getLetter());
        userService.saveUser(user);
    }

    public List<CaptainInfo> getCaptainInfo() {
        Boolean isCaptain = true;
        List<User> captainInfo = userService.getCaptainInfo(isCaptain);
        return userMapper.toCaptainsInfo(captainInfo);
    }
}
