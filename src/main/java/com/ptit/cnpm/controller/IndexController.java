package com.ptit.cnpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/1")
    public String homePage1(){
        return "muon-sach";
    }

    @GetMapping("/2")
    public String homePage0(){
        return "phieu-muon";
    }

    @GetMapping("/3")
    public String homePage3(){
        return "sign-in";
    }
}
