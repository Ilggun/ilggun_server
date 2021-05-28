package com.ilggun.backend.user.service;

import com.ilggun.backend.response.CommonResult;
import com.ilggun.backend.response.ListResult;
import com.ilggun.backend.response.ResponseService;
import com.ilggun.backend.response.SingleResult;
import com.ilggun.backend.user.domain.User;
import com.ilggun.backend.user.domain.UserRepository;
import com.ilggun.backend.user.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ResponseService responseService;

    @Transactional
    public SingleResult<User> save(UserSaveRequestDto requestDto) {
        return responseService.getSingleResult(userRepository.save(requestDto.toEntity()));
    }

    @Transactional
    public CommonResult delete(Long id) {
        userRepository.deleteById(id);
        //        try {
        //            userRepository.deleteById(id);
        //        } catch (Exception e) {
        //            return responseService.getFailResult();
        //        }
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
                        .orElseThrow(() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")));
    }
}
