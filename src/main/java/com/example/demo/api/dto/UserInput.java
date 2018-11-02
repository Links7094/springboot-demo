package com.example.demo.api.dto;

import com.example.demo.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class UserInput implements Converter<User>{

    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id不小于1")
    private int id;

    @Override
    public User convert() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}
