package com.tgy.knowledge.domain.dto;

import com.tgy.knowledge.domain.entity.User;
import com.tgy.knowledge.util.DTOConvert;
import org.springframework.beans.BeanUtils;

/**
 * UserInputDTO
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @date 2019-04-23 17:16
 **/

public class UserInputDTO {
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
        UserInputDTOConvert userInputDTOConvert = new UserInputDTOConvert();
        User convert = userInputDTOConvert.convert(this);
        return convert;
    }

    private static class UserInputDTOConvert implements DTOConvert<UserInputDTO,User> {
        @Override
        public User convert(UserInputDTO userInputDTO) {
            User user = new User();
            BeanUtils.copyProperties(userInputDTO,user);
            return user;
        }
    }
}
