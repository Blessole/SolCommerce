package com.blessole.solcommerce.dto;

import com.blessole.solcommerce.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRespDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Address address;

}
