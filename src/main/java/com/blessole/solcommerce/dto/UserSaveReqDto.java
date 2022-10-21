package com.blessole.solcommerce.dto;

import com.blessole.solcommerce.domain.Address;
import com.blessole.solcommerce.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;

@Getter
@NoArgsConstructor
public class UserSaveReqDto {

    private String username;
    private String password;
    private String passwordCheck;
    private String name;

    private String city;
    private String detail;
    private String zipcode;

    @Builder
    public UserSaveReqDto(String username, String password, String passwordCheck, String name, String city, String detail, String zipcode) {
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.name = name;
        this.city = city;
        this.detail = detail;
        this.zipcode = zipcode;
    }

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .build();
    }
}
