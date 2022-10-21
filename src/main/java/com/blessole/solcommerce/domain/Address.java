package com.blessole.solcommerce.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
@Getter
public class Address {

    @NotEmpty
    private String city;

    @NotEmpty
    private String detail;

    @NotEmpty
    private String zipcode;

    // JPA 스펙상, @Entity나 @Embeddable 타입은 기본 생성자를 public 또는 protected로 설정해야함(public보단 protected로 만드는게 더 안전)
    protected Address(){}

    @Builder
    public Address(String city, String detail, String zipcode) {
        this.city = city;
        this.detail = detail;
        this.zipcode = zipcode;
    }
}
