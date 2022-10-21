package com.blessole.solcommerce.dao;

import com.blessole.solcommerce.domain.Address;
import com.blessole.solcommerce.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void insertTest(){
        for (int i=0; i<10; i++){
            User user = User.builder()
                    .username("user"+i)
                    .password("1234")
                    .name("name"+i)
                    .build();

            repository.save(user);
        }
    }
}