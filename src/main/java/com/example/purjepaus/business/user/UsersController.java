package com.example.purjepaus.business.user;

import com.example.purjepaus.business.user.dto.NewUser;
import com.example.purjepaus.business.user.dto.UserInfo;
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
    public UserInfo updateUserInfo(@RequestParam Integer userId) {
        return null;
    }

    @PatchMapping("/user")
    @Operation(summary = "Muudab osaliselt kasutaja andmeid süsteemis")
    public void updateUserInfo(@RequestParam Integer userId, @RequestBody UserInfo userInfo) {
        usersService.updateUserInfo(userId, userInfo);
    }
}
