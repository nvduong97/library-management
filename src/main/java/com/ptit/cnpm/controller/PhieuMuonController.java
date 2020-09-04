package com.ptit.cnpm.controller;

import com.ptit.cnpm.entity.PhieuMuon;
import com.ptit.cnpm.service.PhieuMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("")
@Controller
public class PhieuMuonController {

    @Autowired
    PhieuMuonService phieuMuonService;

    @GetMapping("/phieu-muon")
    public String phieuMuon(Model model, @RequestParam(defaultValue = "0", name = "id", required = false) Integer id) {
        Optional<PhieuMuon> phieuMuon = phieuMuonService.findById(id);
        if(phieuMuon.isPresent()){
            model.addAttribute("phieuMuon", phieuMuon.get());
            return "phieu-muon";
        }
        return "blank_page";
    }

    @PostMapping("/api/luu/phieu-muon")
    public ResponseEntity<?> luuPhieuMuon(@RequestBody PhieuMuon phieuMuon) {
        return ResponseEntity.ok(phieuMuonService.save(phieuMuon));
    }
}
