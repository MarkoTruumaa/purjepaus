package com.example.purjepaus.domain.user.role;

import com.example.purjepaus.domain.user.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.name = ?1")
    Role findRoleBy(String roleName);
}