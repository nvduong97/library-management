package com.ptit.cnpm.controller;

import com.ptit.cnpm.entity.DauSach;
import com.ptit.cnpm.entity.Sach;
import com.ptit.cnpm.repository.SachRepository;
import com.ptit.cnpm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("")
@Controller
public class SachController {
    @Autowired
    TestService service;

    @GetMapping("/sach")
    public ResponseEntity<?> getSach() {
        Sach result = service.getSach();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/dausach")
    public ResponseEntity<?> getDauSach() {
        DauSach result = service.DauSach();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
