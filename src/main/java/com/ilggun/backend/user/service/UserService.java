package com.ilggun.backend.user.service;

import com.ilggun.backend.advice.exception.CUserNotFoundException;
import com.ilggun.backend.advice.exception.CUsernameSigninFailedException;
import com.ilggun.backend.config.security.JwtTokenProvider;
import com.ilggun.backend.response.CommonResult;
import com.ilggun.backend.response.ListResult;
import com.ilggun.backend.response.ResponseService;
import com.ilggun.backend.response.SingleResult;
import com.ilggun.backend.user.domain.User;
import com.ilggun.backend.user.domain.UserRepository;
import com.ilggun.backend.user.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ResponseService responseService;

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public CommonResult signup(UserSaveRequestDto requestDto) {
        return responseService.getSingleResult(userRepository.save(
                User.builder()
                        .username(requestDto.getUsername())
                        .name(requestDto.getName())
                        .password(passwordEncoder.encode(requestDto.getPassword()))
                        .email(requestDto.getEmail())
                        .phone(requestDto.getPhone())
                        .roles(Collections.singletonList("ROLE_USER"))
                        .build()
        ));
    }

    @Transactional
    public SingleResult<String> signin(String id, String password) {
        User user = userRepository.findByUsername(id).orElseThrow(CUsernameSigninFailedException::new);
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new CUsernameSigninFailedException();
        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getId()), user.getRoles()));
    }

    @Transactional
    public CommonResult delete(Long id) {
        userRepository.deleteById(id);
        return responseService.getSuccessResult();
    }

    @Transactional
    public ListResult<User> findAllUser() {
        return responseService.getListResult(userRepository.findAll());
    }

    @Transactional
    public SingleResult<User> findByUserId(Long id) {
        return responseService.getSingleResult(
                userRepository
                        .findById(id)
                        .orElseThrow(CUserNotFoundException::new));
    }

    @Transactional
    public SingleResult<User> findByUsername(String username) {
        return responseService.getSingleResult(
                userRepository
                        .findByUsername(username)
                        .orElseThrow(CUserNotFoundException::new));
    }
}
