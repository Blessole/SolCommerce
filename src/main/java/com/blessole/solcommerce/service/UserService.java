package com.blessole.solcommerce.service;

import com.blessole.solcommerce.dao.UserRepository;
import com.blessole.solcommerce.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long joinUser(User user) {

        // 비밀번호 암호화
        // security 문제 해결 후 추가하기!

        return userRepository.save(user).getId();
    }
}
