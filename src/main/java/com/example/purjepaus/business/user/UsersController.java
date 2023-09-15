package com.example.purjepaus.business.user;

import com.example.purjepaus.business.user.dto.NewUser;
import com.example.purjepaus.business.user.dto.UserInfo;
import com.example.purjepaus.business.user.dto.UserPassword;
import com.example.purjepaus.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/user")
    @Operation(summary = "Uue kasutaja lisamine süsteemi.",
            description = "address ja telephone number pole kohustuslikud väljad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega kasutaja on süsteemis juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addNewUser(@RequestBody NewUser newUser) {
        usersService.addNewUser(newUser);
    }

    @GetMapping("/user")
    @Operation(summary = "Leiab userId abil kasutaja profiili andmed")
    public UserInfo getUserInfo(@RequestParam Integer userId) {
        return usersService.getUserInfo(userId);
    }

    @PatchMapping("/user")
    @Operation(summary = "Muudab osaliselt kasutaja andmeid süsteemis",
            description = "Ei muuda kasutaja username-i, passwordi, statust ja role-i")
    public void updateUserInfo(@RequestParam Integer userId, @RequestBody UserInfo userInfo) {
        usersService.updateUserInfo(userId, userInfo);
    }
    @GetMapping("user/password")
    @Operation(summary = "Leiab userId abil kasutaja parooli")
    public UserPassword getUserPassword(@RequestParam Integer userId) {
        return usersService.getUserPassword(userId);
    }

    @PatchMapping("/user/password")
    @Operation(summary = "Leiab userId abil kasutaja ja muudab ära tema parooli")
    public void updateUserPassword(@RequestParam Integer userId, String newPassword) {
        usersService.updateUserPassword(userId, newPassword);

    }
    @DeleteMapping("/user")
    @Operation(summary = "Eemaldab user info",
            description = "Muudab ära user staatuse active -> deleted")
    public void deleteUser(@RequestParam Integer userId) {
        usersService.deleteUser(userId);

    }
}
