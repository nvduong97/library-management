package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.DauSach;
import com.ptit.cnpm.entity.Sach;
import com.ptit.cnpm.repository.DauSachRepository;
import com.ptit.cnpm.repository.SachRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    SachRepository sachRepository;
    @Autowired
    DauSachRepository dauSachRepository;


    public Sach getSach(){
        return sachRepository.findById(1).get();
    }

    public DauSach DauSach() {
        return dauSachRepository.findById(1).get();
    }
}
