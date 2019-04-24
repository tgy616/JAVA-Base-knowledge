package com.tgy.knowledge.controller;

import com.tgy.knowledge.domain.dto.UserInputDTO;
import com.tgy.knowledge.domain.entity.User;
import com.tgy.knowledge.service.UserService;
import com.tgy.knowledge.util.Impl.UserInputDTOConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserApi
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @date 2019-04-23 17:10
 **/
@RestController
@RequestMapping("/v1/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(UserInputDTO userInputDTO){
        User user = new UserInputDTOConvert().convert(userInputDTO);
        return userService.addUser(user);
    }
}
