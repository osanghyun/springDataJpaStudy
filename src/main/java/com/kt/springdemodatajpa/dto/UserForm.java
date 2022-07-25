package com.kt.springdemodatajpa.dto;


import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    private String userId;
    private String password;
    private String email;
    private int age;

}
