package com.ptit.cnpm.controller;

import com.ptit.cnpm.entity.BanDoc;
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
import org.springframework.web.bind.annotation.RequestParam;


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
    public String getBanDoc(Model model, @RequestParam(defaultValue = "0", name = "ban-doc", required = false) Integer key ) {
        BanDoc result = banDocService.getBanDoc(key);
        model.addAttribute("banDoc", result);
        model.addAttribute("sachMuons", result.getChiTietMuons());
        model.addAttribute("sachDaMuons", result.getChiTietMuons());
//        model.addAttribute("banDoc", result.getBanDoc());
//        model.addAttribute("sachMuons", result.getSanhDangMuons());
//        model.addAttribute("sachDaMuons", result.getSanhDaMuons());
        return "muon-sach";
    }

    @GetMapping("/api/ban-doc/{id}")
    public ResponseEntity<Object> getBanDocById(@PathVariable int id ) {
        BanDoc Res = banDocService.getBanDocById(id);
        System.out.println("");
        return ResponseEntity.ok(banDocService.getBanDocById(id));
    }
}
