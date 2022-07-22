package com.kt.springdemodatajpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table
public class UserInfo {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long index;

    private String userId;

    private String password;

    private String email;

    private int age;

}
