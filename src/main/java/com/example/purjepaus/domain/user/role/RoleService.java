package com.example.purjepaus.domain.user.role;

import com.example.purjepaus.domain.user.role.Role;
import com.example.purjepaus.domain.user.role.RoleRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;

    public Role getRoleBy(String roleName) {
        return roleRepository.findRoleBy(roleName);
    }
}
