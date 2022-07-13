package com.example.ict.repostiory;

import com.example.ict.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IctRepository  extends JpaRepository<Member,String> {

}
