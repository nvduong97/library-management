package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.ChiTietMuon;
import com.ptit.cnpm.exception.NotFoundException;
import com.ptit.cnpm.model.BanDocDTO;
import com.ptit.cnpm.repository.BanDocRepository;
import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.repository.ChiTietMuonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BanDocService {

    @Autowired
    BanDocRepository banDocRepository;

    @Autowired
    ChiTietMuonRepository chiTietMuonRepository;

    public BanDocDTO getBanDoc(int id) {
        Optional<BanDoc> banDoc = banDocRepository.findById(id);
        if (!banDoc.isPresent()) {
            return new BanDocDTO();
        }
        List<ChiTietMuon> sachDaMuons = chiTietMuonRepository.findByIdAndBanDoc(1, id).orElse(new ArrayList<>());
        List<ChiTietMuon> sachDangMuons = chiTietMuonRepository.findByIdAndBanDoc(0, id).orElse(new ArrayList<>());
        return BanDocDTO.builder()
                .banDoc(banDoc.get())
                .sanhDaMuons(sachDaMuons)
                .sanhDangMuons(sachDangMuons)
                .build();
    }

    public BanDoc getBanDocById(int id) {
        return banDocRepository.findById(id).orElseThrow(() -> new NotFoundException("Dữ liệu yêu cầu không tồn tại"));
    }
}
