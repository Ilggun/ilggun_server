package com.ilggun.backend.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUpdateRequestDto {
    private String name;
    private String certification;
    private Long userId;

    @Builder
    ProductUpdateRequestDto(String name, String certification, Long userId) {
        this.name = name;
        this.certification = certification;
        this.userId = userId;
    }
}
