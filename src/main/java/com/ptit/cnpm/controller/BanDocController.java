package com.ptit.cnpm.controller;

import com.ptit.cnpm.model.BanDocDTO;
import com.ptit.cnpm.service.BanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("")
@Controller
public class BanDocController {
    @Autowired
    BanDocService banDocService;

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/muon-sach")
    public String muonSach(Model model) {
        return "muon-sach";
    }

    @GetMapping("/ban-doc")
    public String getBanDoc2(Model model) {
        BanDocDTO result = banDocService.getBanDoc(1);
        model.addAttribute("banDoc", result.getBanDoc());
        model.addAttribute("sachMuons", result.getSanhDangMuons());
        model.addAttribute("sachDaMuons", result.getSanhDaMuons());
        return "ban-doc";
    }

    @GetMapping("/ban-docs")
    public String getBanDoc1(Model model) {
        return "muon-sach";
    }

    @GetMapping("/api/ban-doc/{key}")
    public ResponseEntity<?> getBanDoc(@PathVariable int key) {
        BanDocDTO result = banDocService.getBanDoc(key);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
