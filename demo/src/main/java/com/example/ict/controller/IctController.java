package com.example.ict.controller;

import com.example.ict.member.Member;
import com.example.ict.service.IctService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class IctController {

    @Autowired
    private final IctService ictService;

    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "hello";
    }

    @GetMapping("/login")
    public String log(){
        return "form";
    }

    @PostMapping("/login")
    public String loginId(@ModelAttribute Member member){
        if(ictService.signIn(member)){
            return "redirect:/";
        }
        return "form";
    }

}