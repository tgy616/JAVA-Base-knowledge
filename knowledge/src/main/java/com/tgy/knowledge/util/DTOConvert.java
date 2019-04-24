package com.tgy.knowledge.util;

import com.tgy.knowledge.domain.dto.UserInputDTO;
import com.tgy.knowledge.domain.entity.User;

/**
 * DTOConvert
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @date 2019-04-23 17:20
 **/
public interface DTOConvert<S,T> {
    User convert(UserInputDTO userInputDTO);

    T convert(S s);
}