package com.ptit.cnpm.service;

import com.ptit.cnpm.repository.ChiTietMuonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietMuonService {

    @Autowired
    ChiTietMuonRepository chiTietMuonRepository;

//    public ChiTietMuon themSachMuon(ChiTietMuonReq req){
//        ChiTietMuon chiTietMuon = new ChiTietMuon();
//        Sach sach = sachRepository.findById(req.getMaSach()).get();
//        BanDoc banDoc = banDocRepository.findById(req.getMaBanDoc()).get();
//
//        chiTietMuon.setTrangThai(0);
//        chiTietMuon.setBanDoc(banDoc);
//        chiTietMuon.setNgayMuon(new Date());
//        chiTietMuon.setNgayTra(new Date());
//        chiTietMuon.setSach(sach);
//        return chiTietMuonRepository.save(chiTietMuon);
//    }
}
