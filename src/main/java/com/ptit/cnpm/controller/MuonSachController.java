package com.ptit.cnpm.controller;

import com.ptit.cnpm.model.BanDocDTO;
import com.ptit.cnpm.service.BanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("")
@Controller
public class MuonSachController {
    @Autowired
    BanDocService banDocService;

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/muon-sach")
    public String getBanDoc(Model model, @RequestParam(defaultValue = "0", name = "ban-doc", required = false) Integer id) {
        BanDocDTO result = banDocService.getBanDoc(id);
        model.addAttribute("banDoc", result.getBanDoc());
        model.addAttribute("sachMuons", result.getSanhDangMuons());
        model.addAttribute("sachDaMuons", result.getSanhDaMuons());
        return "muon-sach";
    }
}
