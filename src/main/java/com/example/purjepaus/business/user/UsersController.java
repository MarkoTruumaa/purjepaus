package com.example.purjepaus.business.user;

import com.example.purjepaus.business.user.dto.UserInfo;
import com.example.purjepaus.business.user.dto.UserInfoUpdate;
import com.example.purjepaus.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public void addNewUser(@RequestBody UserInfo userInfo) {
        usersService.addNewUser(userInfo);
    }

    @PutMapping("/user")
    @Operation(summary = "Muudab kasutaja andmeid süsteemis")
    public void updateUserInfo(@RequestBody UserInfoUpdate userInfoUpdate) {
        usersService.updateUserInfo(userInfoUpdate);
    }
}
