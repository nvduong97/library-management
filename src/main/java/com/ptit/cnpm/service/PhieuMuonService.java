package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.entity.ChiTietMuon;
import com.ptit.cnpm.entity.PhieuMuon;
import com.ptit.cnpm.exception.BadRequestException;
import com.ptit.cnpm.repository.ChiTietMuonRepository;
import com.ptit.cnpm.repository.PhieuMuonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
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

    public PhieuMuon save(PhieuMuon phieuMuonReq){
        if(phieuMuonReq.getBanDoc() == null || phieuMuonReq.getChiTietMuons() == null){
            throw new BadRequestException("Dữ liệu không hợp lệ");
        }
        Integer maVach = phieuMuonRepository.getMaVachMax();
        phieuMuonReq.setMaVach((maVach == null) ? 10000 : ++maVach);
        PhieuMuon phieuMuon = phieuMuonRepository.save(phieuMuonReq);

        List<ChiTietMuon> chiTietMuonList = phieuMuonReq.getChiTietMuons();
        Date ngayMuon = new Date();
        Calendar ngayTra = Calendar.getInstance();
        ngayTra.add(Calendar.DATE, 30);

        chiTietMuonList.forEach(chiTietMuon -> {
            chiTietMuon.setTrangThai(0);
            chiTietMuon.setNgayMuon(ngayMuon);
            chiTietMuon.setNgayTra(ngayTra.getTime());
            chiTietMuon.setBanDoc(phieuMuonReq.getBanDoc());
            chiTietMuon.setPhieuMuon(phieuMuon);
            chiTietMuonRepository.save(chiTietMuon);
        });
        return phieuMuon;
    }
}
