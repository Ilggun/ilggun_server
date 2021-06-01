package com.ilggun.backend.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductSaveRequestDto {
    private String name;
    private String certification;
    private Long userId;

    @Builder
    ProductSaveRequestDto(String name, String certification, Long userId) {
        this.name = name;
        this.certification = certification;
        this.userId = userId;
    }
}
