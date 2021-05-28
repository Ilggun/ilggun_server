package com.ilggun.backend.user.controller;

import com.ilggun.backend.user.dto.UserSaveRequestDto;
import com.ilggun.backend.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "회원 가입", notes = "회원 가입입니다.")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }
}
