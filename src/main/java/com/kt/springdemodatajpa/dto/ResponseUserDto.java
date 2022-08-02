package com.kt.springdemodatajpa.dto;

import com.kt.springdemodatajpa.domain.UserEntity;
import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDto {
    private Long index;
    private String userId;
    private String password;
    private String email;
    private int age;
    private LocalDateTime registerDate;
    private LocalDateTime modifyDate;

    public ResponseUserDto(UserEntity userEntity) {
        this.index = userEntity.getIndex();
        this.userId = userEntity.getUserId();
        this.password = userEntity.getPassword();
        this.email = userEntity.getEmail();
        this.age = userEntity.getAge();
        this.registerDate = userEntity.getRegisterDate();
        this.modifyDate = userEntity.getModifyDate();
    }
}
