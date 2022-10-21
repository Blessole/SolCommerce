package com.blessole.solcommerce.controller;

import com.blessole.solcommerce.domain.Address;
import com.blessole.solcommerce.domain.User;
import com.blessole.solcommerce.dto.UserSaveReqDto;
import com.blessole.solcommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/new")
    public ModelAndView joinForm(){

        ModelAndView joinMV = new ModelAndView();
        joinMV.setViewName("user/joinForm");
        joinMV.addObject("userDto", new UserSaveReqDto());
        return joinMV;
    }

    @PostMapping("/new")
    public Map<String, Object> joinAction(@RequestBody UserSaveReqDto userDto){
        Map<String, Object> map = new HashMap<>();

        Address address = new Address(userDto.getCity(), userDto.getDetail(), userDto.getZipcode());
        if (userDto.getPassword().equals(userDto.getPasswordCheck())){
            log.info("비밀번호 일치");
            User joinUser = User.builder()
                    .username(userDto.getUsername())
                    .password(userDto.getPassword())
                    .name(userDto.getName())
                    .address(address).build();

            userService.joinUser(joinUser);
            map.put("result", 0);
        } else {
            log.info("비밀번호 일치하지 않음");
            map.put("result", 1);
        }
        return map;
    }
}
