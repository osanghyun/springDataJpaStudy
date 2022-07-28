package com.kt.springdemodatajpa.dto;


import com.kt.springdemodatajpa.domain.UserEntity;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserDto {

    private Long index;
    private String userId;
    private String password;
    private String email;
    private int age;

}
