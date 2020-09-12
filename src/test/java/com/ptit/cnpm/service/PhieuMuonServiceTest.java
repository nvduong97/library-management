package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class PhieuMuonServiceTest {

    @Autowired
    PhieuMuonService phieuMuonService;

    @Test
    public void findByIdPass() {
        PhieuMuon phieuMuon = phieuMuonService.findById(1).get();
        assertNotNull(phieuMuon);
        assertEquals(1, phieuMuon.getMaPhieuMuon());
    }

    @Test
    public void findByIdFail() {
        Optional<PhieuMuon> phieuMuon = phieuMuonService.findById(100);
        assertEquals(Optional.empty(), phieuMuon);
    }

    @Test
    @Transactional
    public void savePass() {
        PhieuMuon phieuMuon = new PhieuMuon();
        BanDoc banDoc = new BanDoc();
        Sach sach = new Sach();
        DauSach dauSach = new DauSach();
        ChiTietMuon chiTietMuon = new ChiTietMuon();
        List<ChiTietMuon> chiTietMuons = new ArrayList<>();

        dauSach.setMaDauSach(1);
        dauSach.setSoLuong(1);
        sach.setMaSach(1);
        sach.setDauSach(dauSach);
        banDoc.setMaBanDoc(1);

        chiTietMuon.setSach(sach);
        chiTietMuon.setBanDoc(banDoc);
        chiTietMuons.add(chiTietMuon);

        phieuMuon.setBanDoc(banDoc);
        phieuMuon.setChiTietMuons(chiTietMuons);

        PhieuMuon result = phieuMuonService.save(phieuMuon);
        assertEquals(1, result.getBanDoc().getMaBanDoc());
    }

    @Test
    @Transactional
    public void saveFail() {
        try {
            PhieuMuon phieuMuon = new PhieuMuon();
            phieuMuonService.save(phieuMuon);
        }catch (Exception e){
            assertEquals("Dữ liệu không hợp lệ", e.getMessage());
        }
    }
}