package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.Sach;
import com.ptit.cnpm.exception.NotFoundException;
import com.ptit.cnpm.repository.SachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SachService {

    @Autowired
    SachRepository sachRepository;

    public Sach getSachById(int id) {
        return sachRepository.findById(id).orElseThrow(() -> new NotFoundException("Dữ liệu yêu cầu không tồn tại"));
    }
}
