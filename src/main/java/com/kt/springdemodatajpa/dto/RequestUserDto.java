package com.kt.springdemodatajpa.dto;


import com.kt.springdemodatajpa.domain.UserEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserDto {

    private Long index;
    private String userId;
    private String password;
    private String email;
    private int age;

}
