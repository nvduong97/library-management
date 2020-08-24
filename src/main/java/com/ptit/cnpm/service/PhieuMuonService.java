package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.entity.ChiTietMuon;
import com.ptit.cnpm.entity.PhieuMuon;
import com.ptit.cnpm.repository.ChiTietMuonRepository;
import com.ptit.cnpm.repository.PhieuMuonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuMuonService {

    @Autowired
    PhieuMuonRepository phieuMuonRepository;

    @Autowired
    ChiTietMuonRepository chiTietMuonRepository;

    public Optional<PhieuMuon> findById(int id) {
        return phieuMuonRepository.findById(id);
    }

    public PhieuMuon save(PhieuMuon phieuMuonReq) {
        phieuMuonReq.setMaVach(12313);
        PhieuMuon phieuMuon = phieuMuonRepository.save(phieuMuonReq);
        List<ChiTietMuon> chiTietMuonList = phieuMuonReq.getChiTietMuons();
        BanDoc banDoc = phieuMuonReq.getBanDoc();

        chiTietMuonList.forEach(chiTietMuon -> {
            chiTietMuon.setBanDoc(banDoc);
            chiTietMuon.setPhieuMuon(phieuMuon);
            chiTietMuonRepository.save(chiTietMuon);
        });
        return phieuMuon;
    }
}
