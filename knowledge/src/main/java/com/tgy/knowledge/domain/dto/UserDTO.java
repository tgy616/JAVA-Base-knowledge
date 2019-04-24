package com.tgy.knowledge.domain.dto;

import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import com.tgy.knowledge.domain.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @date 2019-04-23 17:24
 **/

public class UserDTO {
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public User convertToUser(){
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        User convert = userDTOConvert.convert(this);
        return convert;
    }

    public UserDTO convertFor(User user){
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        UserDTO convert = userDTOConvert.reverse().convert(user);
        return convert;
    }

    private static class UserDTOConvert extends Converter<UserDTO, User> {
        @Override
        protected User doForward(UserDTO userDTO) {
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            return user;
        }

        @Override
        protected UserDTO doBackward(User user) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user,userDTO);
            return userDTO;
        }
    }
}
