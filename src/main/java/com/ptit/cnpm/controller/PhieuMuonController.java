package com.ptit.cnpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhieuMuonController {

    @GetMapping("/phieu-muon")
    public String phieuMuon(){
        return "phieu-muon";
    }
}
