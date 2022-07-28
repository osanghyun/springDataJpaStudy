package com.kt.springdemodatajpa.domain;

import com.kt.springdemodatajpa.domain.base.BaseEntity;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long index;

    @NotNull
    private String userId;

    private String password;

    private String email;

    private int age;


}
