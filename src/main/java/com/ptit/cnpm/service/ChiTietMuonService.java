package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.entity.ChiTietMuon;
import com.ptit.cnpm.entity.Sach;
import com.ptit.cnpm.model.ChiTietMuonReq;
import com.ptit.cnpm.repository.BanDocRepository;
import com.ptit.cnpm.repository.ChiTietMuonRepository;
import com.ptit.cnpm.repository.SachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChiTietMuonService {

    @Autowired
    ChiTietMuonRepository chiTietMuonRepository;

    @Autowired
    BanDocRepository banDocRepository;

    @Autowired
    SachRepository sachRepository;

    public ChiTietMuon themSachMuon(ChiTietMuonReq req){
        ChiTietMuon chiTietMuon = new ChiTietMuon();
        Sach sach = sachRepository.findById(req.getMaSach()).get();
        BanDoc banDoc = banDocRepository.findById(req.getMaBanDoc()).get();

        chiTietMuon.setTrangThai(0);
        chiTietMuon.setBanDoc(banDoc);
        chiTietMuon.setNgayMuon(new Date());
        chiTietMuon.setNgayTra(new Date());
        chiTietMuon.setSach(sach);
        return chiTietMuonRepository.save(chiTietMuon);
    }

//    public List<ChiTietMuon> getSachDangMuon(){
//        List<ChiTietMuon> chiTietMuons = chiTietMuonRepository.findAllByTrangThai(0).get();
//        return chiTietMuons;
//    }
//
//    public List<ChiTietMuon> getSachDaTra(){
//        return chiTietMuonRepository.findAllByTrangThai(1).get();
//    }

    public ChiTietMuon getSachMuon() {
        return chiTietMuonRepository.findById(1).get();
    }
}
