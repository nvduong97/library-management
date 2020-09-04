package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.NhanVien;
import com.ptit.cnpm.model.NhanVienReq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
public class NhanVienServiceTest {

    @Autowired
    NhanVienService nhanVienService;

    @Test
    public void createNhanVienPass() {
        NhanVienReq nhanVienReq = new NhanVienReq("duongtest","1234");
        NhanVien nhanVien = nhanVienService.createNhanVien(nhanVienReq);
        assertNotNull(nhanVien);
        assertEquals("duongtest", nhanVien.getTaiKhoan());
    }

    @Test
    public void createNhanVienFail() {
        try {
            NhanVienReq nhanVienReq = new NhanVienReq("duongduong","1234");
            nhanVienService.createNhanVien(nhanVienReq);
        }catch (Exception e){
            assertEquals("Tài khoản đã tồn tại",e.getMessage());
        }
    }
}