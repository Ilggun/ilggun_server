package com.ilggun.backend.user.controller;

import com.ilggun.backend.response.CommonResult;
import com.ilggun.backend.response.ListResult;
import com.ilggun.backend.response.SingleResult;
import com.ilggun.backend.user.domain.User;
import com.ilggun.backend.user.service.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "X-AUTH-TOKEN",
                    value = "로그인 성공 후 access_token",
                    required = true,
                    dataType = "String",
                    paramType = "header")
    })
    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원의 정보를 출력합니다.")
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ListResult<User> findAllUser() {
        return userService.findAllUser();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "X-AUTH-TOKEN",
                    value = "로그인 성공 후 access_token",
                    required = true,
                    dataType = "String",
                    paramType = "header")
    })
    @ApiOperation(value = "개별 회원 정보 조회", notes = "개별 회원의 정보를 조회합니다.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SingleResult<User> findUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();
        return userService.findByUsername(id);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "X-AUTH-TOKEN",
                    value = "로그인 성공 후 access_token",
                    required = true,
                    dataType = "String",
                    paramType = "header")
    })
    @ApiOperation(value = "회원 계정 삭제", notes = "회원의 계정을 삭제합니다.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommonResult delete(@PathVariable Long id) {
        return userService.delete(id);
    }

}
