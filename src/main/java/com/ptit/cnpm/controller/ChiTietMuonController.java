package com.ptit.cnpm.controller;

import com.ptit.cnpm.entity.ChiTietMuon;
import com.ptit.cnpm.model.ChiTietMuonReq;
import com.ptit.cnpm.service.ChiTietMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("")
@Controller
public class ChiTietMuonController {

    @Autowired
    ChiTietMuonService chiTietMuonService;

    @GetMapping("/sachMuon")
    public ResponseEntity<Object> getSachMuon() {
        ChiTietMuon result = chiTietMuonService.getSachMuon();
        System.out.println("");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/sachDaMuons")
    public ResponseEntity<?> getSachDaMuons() {
        List<ChiTietMuon> result = chiTietMuonService.getSachDaTra();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/sachDangMuons")
    public ResponseEntity<?> getSachDangMuons() {
        List<ChiTietMuon> result = chiTietMuonService.getSachDangMuon();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/themDangMuon")
    public ResponseEntity<?> themSachMuon(@RequestBody ChiTietMuonReq req) {
        ChiTietMuon result = chiTietMuonService.themSachMuon(req);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
