package com.ptit.cnpm.controller;

import com.ptit.cnpm.entity.DauSach;
import com.ptit.cnpm.entity.Sach;
import com.ptit.cnpm.service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/sach")
    public ResponseEntity<?> getSach() {
        Sach result = sachService.getSach();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/dausach")
    public ResponseEntity<?> getDauSach() {
        DauSach result = sachService.DauSach();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/api/sach/{id}")
    public ResponseEntity<?> getSachById(@PathVariable int id) {
        return ResponseEntity.ok(sachService.getSachById(id));
    }
}
