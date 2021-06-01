package com.ilggun.backend.user.dto;

import com.ilggun.backend.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;

    @Builder
    UserSaveRequestDto(String name, String username, String password, String email, String phone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
