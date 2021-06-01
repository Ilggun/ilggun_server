package com.ilggun.backend.product.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.ilggun.backend.product.domain.Product;
import lombok.Getter;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter
public class ProductListResponseDto {
    private final Long id;
    private final String name;
    private final String certification;

    public ProductListResponseDto(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.certification = entity.getCertification();
    }
}
