package com.tgy.knowledge.util.Impl;

import com.tgy.knowledge.domain.dto.UserInputDTO;
import com.tgy.knowledge.domain.entity.User;
import com.tgy.knowledge.util.DTOConvert;
import org.springframework.beans.BeanUtils;

/**
 * UserInputDTOConvert
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @date 2019-04-23 17:20
 **/

public class UserInputDTOConvert implements DTOConvert {
    @Override
    public User convert(UserInputDTO userInputDTO) {
        User user = new User();
        BeanUtils.copyProperties(userInputDTO,user);
        return user;
    }

    @Override
    public Object convert(Object o) {
        return null;
    }
}
