package com.blessole.solcommerce.domain;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Table(name = "user_entity")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    @Builder
    public User(String username, String password, String name, Address address){
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
    }
}
