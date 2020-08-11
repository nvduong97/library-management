package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.ChiTietMuon;
import com.ptit.cnpm.model.BanDocDTO;
import com.ptit.cnpm.repository.BanDocRepository;
import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.repository.ChiTietMuonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BanDocService {

    @Autowired
    BanDocRepository banDocRepository;

    @Autowired
    ChiTietMuonRepository chiTietMuonRepository;

    public BanDocDTO getBanDoc(int key) {
        BanDoc banDoc = banDocRepository.findByMaBanDocOrMaVach(key, key).get();
        List<ChiTietMuon> sachDaMuons = chiTietMuonRepository.findAllByTrangThai(1).orElse(new ArrayList<>());
        List<ChiTietMuon> sachDangMuons = chiTietMuonRepository.findAllByTrangThai(0).orElse(new ArrayList<>());
        return BanDocDTO.builder()
                .banDoc(banDoc)
                .sanhDaMuons(sachDaMuons)
                .sanhDangMuons(sachDangMuons)
                .build();
    }
}
