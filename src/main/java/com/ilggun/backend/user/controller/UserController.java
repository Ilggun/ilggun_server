package com.ilggun.backend.user.controller;

import com.ilggun.backend.response.CommonResult;
import com.ilggun.backend.response.ListResult;
import com.ilggun.backend.response.ResponseService;
import com.ilggun.backend.response.SingleResult;
import com.ilggun.backend.user.domain.User;
import com.ilggun.backend.user.dto.UserSaveRequestDto;
import com.ilggun.backend.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    public SingleResult<User> save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @ApiOperation(value = "회원 계정 삭제", notes = "회원의 계정을 삭제합니다.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommonResult delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @ApiOperation(value = "모든 회원 정보", notes = "모든 회원의 정보를 출력합니다.")
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ListResult<User> findAllUser() {
        return userService.findAllUser();
    }

    @ApiOperation(value = "개별 회원 정보 조회", notes = "개별 회원의 정보를 조회합니다.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SingleResult<User> findUserById(@ApiParam(value = "회원 고유 아이디", required = true) @PathVariable Long id) {
        return userService.findByUserId(id);
    }
}
