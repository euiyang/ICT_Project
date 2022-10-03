package com.example.ict.member;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // 테이블과 1대1 매칭되는 객체 의미
@Table(name="m")
public class Member {

    @Id//primary key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seq")
    private Long num;

    @Column(name="user_id")
    private String id;

    @Column(name="user_pw")
    private String pw;

}
