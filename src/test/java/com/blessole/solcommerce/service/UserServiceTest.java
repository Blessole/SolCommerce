package com.blessole.solcommerce.service;

import com.blessole.solcommerce.dao.UserRepository;
import com.blessole.solcommerce.domain.User;
import com.blessole.solcommerce.dto.UserSaveReqDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    private UserSaveReqDto getDto(int number){
        return UserSaveReqDto.builder()
                .username("username"+number)
                .password("password"+number)
                .passwordCheck("passwordCheck"+number)
                .name("name"+number)
                .city("city"+number)
                .detail("detail"+number)
                .zipcode("zipcode"+number)
                .build();
    }

    @Test
    public void 회원가입() {
        // given
        UserSaveReqDto userA = getDto(1);
        User savedUser = userRepository.save(userA.toEntity());

    }
}