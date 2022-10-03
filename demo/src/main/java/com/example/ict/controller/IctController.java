package com.example.ict.controller;

import com.example.ict.member.Member;
import com.example.ict.service.IctService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class IctController {
    @Autowired
    private final IctService ictService;

    @PostMapping("/api/login")
    @ResponseBody
    public String loginId(@ModelAttribute Member member){

        if(ictService.signIn(member)){
            return "success";
        }
        return "fail";
    }

    @GetMapping("/api/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }
}