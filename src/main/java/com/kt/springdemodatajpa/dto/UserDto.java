package com.kt.springdemodatajpa.dto;


import com.kt.springdemodatajpa.domain.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long index;
    private String userId;
    private String password;
    private String email;
    private int age;

    public UserDto(UserEntity userEntity) {
        this.index = userEntity.getIndex();
        this.userId = userEntity.getUserId();
        this.password = userEntity.getPassword();
        this.email = userEntity.getEmail();
        this.age = userEntity.getAge();
    }

}
