package com.example.ict.member;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="m")
public class Member {

    @Id//primary key 지정
    @Column(name="user_id")
    private String id;

    @Column(name="user_pw")
    private String pw;

}
