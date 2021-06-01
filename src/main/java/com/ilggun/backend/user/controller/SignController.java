package com.ilggun.backend.user.controller;

import com.ilggun.backend.response.CommonResult;
import com.ilggun.backend.response.SingleResult;
import com.ilggun.backend.user.dto.UserSaveRequestDto;
import com.ilggun.backend.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"0. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class SignController {
    private final UserService userService;

    @ApiOperation(value = "회원 가입", notes = "회원 가입입니다.")
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResult save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.signup(requestDto);
    }

    @ApiOperation(value = "로그인", notes = "username 으로 로그인 처리를 합니다.")
    @PostMapping("/signin")
    public SingleResult<String> signin(@ApiParam(value = "회원 아이디: username", required = true) @RequestParam String id,
                                       @ApiParam(value = "비밀번호", required = true) @RequestParam String password) {
        return userService.signin(id, password);
    }
}
