package com.ilggun.backend.data.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ilggun.backend.data.domain.Data;

import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DataListResponseDto {
    private Long id;
    private double gas;
    private double humidity;
    private double smoke;
    private double temperature;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    public DataListResponseDto(Data entity) {
        this.id = entity.getId();
        this.gas = entity.getGas();
        this.humidity = entity.getHumidity();
        this.smoke = entity.getSmoke();
        this.temperature = entity.getTemperature();
        this.time = entity.getCreateDate();
    }
}
