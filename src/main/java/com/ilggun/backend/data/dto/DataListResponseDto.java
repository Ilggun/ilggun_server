package com.ilggun.backend.data.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ilggun.backend.data.domain.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter
public class DataListResponseDto {
    private final Long id;
    private final double gas;
    private final double humidity;
    private final double smoke;
    private final double temperature;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime time;

    public DataListResponseDto(Data entity) {
        this.id = entity.getId();
        this.gas = entity.getGas();
        this.humidity = entity.getHumidity();
        this.smoke = entity.getSmoke();
        this.temperature = entity.getTemperature();
        this.time = entity.getCreateDate();
    }
}
