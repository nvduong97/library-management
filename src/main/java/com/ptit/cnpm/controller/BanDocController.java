package com.ptit.cnpm.controller;

import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.service.BanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/muon-sach")
@Controller
public class BanDocController {
    @Autowired
    BanDocService banDocService;

    @GetMapping("")
    public ResponseEntity<?> getBanDocs() {
        List<BanDoc> result = banDocService.getBanDocs();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/1")
    public ResponseEntity<?> getBanDoc() {
        BanDoc result = banDocService.getBanDoc();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
