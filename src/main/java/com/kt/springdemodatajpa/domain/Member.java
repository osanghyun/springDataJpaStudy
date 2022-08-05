package com.kt.springdemodatajpa.domain;

import com.kt.springdemodatajpa.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

// setter 가 아닌 명확한 메서드 만들기. 어떤 의도인지 확인하기위해. 변경이 불가한 데이터도 변경될수있음.
// user예약어 정리, 테이블 클래스 이름 애노테이션으로 다르게
// todo @Table(name = "users") -> 'users' 테이블을 해결할 수 없다.
@Entity
@Getter
@NoArgsConstructor
@Table(name = "users") // 테이블 이름 지정가능함. 테이블 명으로 Entity는 잘 사용안함. 클래스와 이름 달라도됨.
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long index;

    @NotBlank
    private String userId;

    private String password;

    private String email;

    private int age;

    public void create(String userId, String password, String email, int age) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.age = age;
    }
    public void update(String password, String email, int age) {
        this.password = password;
        this.email = email;
        this.age = age;
    }

}
