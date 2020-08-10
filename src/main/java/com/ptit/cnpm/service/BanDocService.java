package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.ChiTietMuon;
import com.ptit.cnpm.repository.BanDocRepository;
import com.ptit.cnpm.entity.BanDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BanDocService {

    @Autowired
    BanDocRepository banDocRepository;

    public List<BanDoc> getBanDocs() {
        return banDocRepository.findAll();
    }

    public BanDoc getBanDoc() {
        BanDoc banDoc = banDocRepository.findById(1).get();

        List<ChiTietMuon> chiTietMuons = banDoc.getChiTietMuons();
        List<ChiTietMuon> result = chiTietMuons.stream().filter(chiTietMuon -> chiTietMuon.getTrangThai() > 0)
                .collect(Collectors.toList());

        banDoc.setChiTietMuons(result);
        return banDoc;
    }
}
