package com.ptit.cnpm.controller;

import com.ptit.cnpm.service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("")
@Controller
public class SachController {

    @Autowired
    SachService sachService;

    @GetMapping("/api/sach/{id}")
    public ResponseEntity<?> getSachById(@PathVariable int id) {
        return ResponseEntity.ok(sachService.getSachById(id));
    }
}
