package com.kt.springdemodatajpa.dto;

import com.kt.springdemodatajpa.domain.Member;
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

    public ResponseUserDto(Member member) {
        this.index = member.getIndex();
        this.userId = member.getUserId();
        this.password = member.getPassword();
        this.email = member.getEmail();
        this.age = member.getAge();
        this.registerDate = member.getRegisterDate();
        this.modifyDate = member.getModifyDate();
    }
}
