package com.ptit.cnpm.controller;

import com.ptit.cnpm.service.BanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class BanDocController {

    @Autowired
    BanDocService banDocService;

    @GetMapping("/api/ban-doc/{id}")
    public ResponseEntity<Object> getBanDocById(@PathVariable int id) {
        return ResponseEntity.ok(banDocService.getBanDocById(id));
    }
}

