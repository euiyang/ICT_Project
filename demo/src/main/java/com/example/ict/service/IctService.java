package com.example.ict.service;

import com.example.ict.member.Member;
import com.example.ict.repostiory.IctRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IctService {
    @Autowired
    private final IctRepository ictRepository;

    public boolean signIn(Member member){
        Optional<Member> user = ictRepository.findById(member.getId());

        if(user.isEmpty()) return false;

        if(!user.get().getPw().equals(member.getPw()))return false;

        return true;
    }
}
