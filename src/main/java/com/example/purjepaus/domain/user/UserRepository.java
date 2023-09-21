package com.example.purjepaus.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username = ?1 and u.password = ?2 and u.status= ?3")
    Optional<User> findUserBy(String username, String password, String status);

    @Query("select (count(u) > 0) from User u where u.username = ?1")
    boolean usernameExistsBy(String username);

    @Query("select (count(u) > 0) from User u where u.id = ?1 and u.password = ?2")
    boolean checkUserBy(Integer userId, String password);

    @Query("select u from User u where u.contact.isCaptain = ?1")
    List<User> findUserBy(Boolean isCaptain);


}