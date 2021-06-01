package com.ilggun.backend.product.service;

import com.ilggun.backend.advice.exception.CProductNotFoundException;
import com.ilggun.backend.advice.exception.CUserNotFoundException;
import com.ilggun.backend.product.dto.ProductListResponseDto;
import com.ilggun.backend.product.dto.ProductSaveRequestDto;
import com.ilggun.backend.product.domain.Product;
import com.ilggun.backend.product.domain.ProductRepository;
import com.ilggun.backend.product.dto.ProductUpdateRequestDto;
import com.ilggun.backend.response.CommonResult;
import com.ilggun.backend.response.ListResult;
import com.ilggun.backend.response.ResponseService;
import com.ilggun.backend.response.SingleResult;
import com.ilggun.backend.user.domain.User;
import com.ilggun.backend.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ResponseService responseService;

    // 제품 등록
    @Transactional
    public SingleResult<Product> save(ProductSaveRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(CUserNotFoundException::new);
        Product product = new Product(requestDto.getName(), requestDto.getCertification(), user);
        return responseService.getSingleResult(productRepository.save(product));
    }

    // 모든 제품 검색
    @Transactional
    public ListResult<ProductListResponseDto> findAllProduct() {
        return responseService.getListResult(
                productRepository
                        .findAll().stream().map(ProductListResponseDto::new).collect(Collectors.toList()));
    }

    // 제품 id로 제품 정보 검색
    @Transactional
    public SingleResult<Product> findByProductId(Long id) {
        return responseService.getSingleResult(
                productRepository
                        .findById(id)
                        .orElseThrow(CProductNotFoundException::new));
    }

    // 제품 id로 제품 정보 변경
    @Transactional
    public SingleResult<Product> update(Long id, ProductUpdateRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(CProductNotFoundException::new);
        product.setName(requestDto.getName());
        product.setCertification(requestDto.getCertification());
        product.setUser(userRepository.findById(requestDto.getUserId()).orElseThrow(CUserNotFoundException::new));
        return responseService.getSingleResult(productRepository.save(product));
    }

    // 제품 id로 제품 정보 삭제
    @Transactional
    public CommonResult deleteByProductId(Long id) {
        productRepository.deleteById(id);
        return responseService.getSuccessResult();
    }

    // 사용자 보유 제품 정보 검색
    @Transactional
    public ListResult<ProductListResponseDto> findByUserId(Long id) {
        return responseService.getListResult(
                productRepository.findByUserId(
                        userRepository
                                .findById(id)
                                .orElseThrow(CUserNotFoundException::new)
                                .getId()).stream().map(ProductListResponseDto::new).collect(Collectors.toList()));
    }

}
