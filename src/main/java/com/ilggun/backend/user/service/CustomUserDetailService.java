package com.ilggun.backend.user.service;

import com.ilggun.backend.advice.exception.CUserNotFoundException;
import com.ilggun.backend.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String userPk) {
        return userRepository.findById(Long.valueOf(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}
