package com.example.purjepaus.business.user;

import com.example.purjepaus.domain.user.contact.Contact;
import com.example.purjepaus.domain.user.contact.ContactMapper;
import com.example.purjepaus.domain.user.UserMapper;
import com.example.purjepaus.domain.user.UserService;
import com.example.purjepaus.domain.user.contact.ContactService;
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

    public void addNewUser(UserInfo userInfo) {
        String username = userInfo.getUsername();
        userService.confirmUsernameAvailability(username);

        Contact contact = contactMapper.toContact(userInfo);
        contactService.saveContact(contact);





    }
}
