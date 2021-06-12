package com.ilggun.backend.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DataSaveRequestDto {
    private Long productId;
    private double gas;
    private double humidity;
    private double smoke;
    private double temperature;

    @Builder
    DataSaveRequestDto(Long productId, double gas, double humidity, double smoke, double temperature) {
        this.productId = productId;
        this.gas = gas;
        this.humidity = humidity;
        this.smoke = smoke;
        this.temperature = temperature;
    }
}
