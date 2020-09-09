package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.DauSach;
import com.ptit.cnpm.entity.PhieuMuon;
import com.ptit.cnpm.exception.BadRequestException;
import com.ptit.cnpm.repository.ChiTietMuonRepository;
import com.ptit.cnpm.repository.DauSachRepository;
import com.ptit.cnpm.repository.PhieuMuonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class PhieuMuonService {

    @Autowired
    PhieuMuonRepository phieuMuonRepository;

    @Autowired
    ChiTietMuonRepository chiTietMuonRepository;

    @Autowired
    DauSachRepository dauSachRepository;

    public Optional<PhieuMuon> findById(int id) {
        return phieuMuonRepository.findById(id);
    }

    public PhieuMuon save(PhieuMuon phieuMuonReq) {
        if (phieuMuonReq.getBanDoc() == null || phieuMuonReq.getChiTietMuons() == null) {
            throw new BadRequestException("Dữ liệu không hợp lệ");
        }
        try {
            Integer maVach = phieuMuonRepository.getMaVachMax();
            phieuMuonReq.setMaVach((maVach == null) ? 10000 : ++maVach);
            PhieuMuon phieuMuon = phieuMuonRepository.save(phieuMuonReq);

            Date ngayMuon = new Date();
            Calendar ngayTra = Calendar.getInstance();
            ngayTra.add(Calendar.DATE, 30);

            phieuMuonReq.getChiTietMuons().forEach(chiTietMuon -> {
                chiTietMuon.setTrangThai(0);
                chiTietMuon.setNgayMuon(ngayMuon);
                chiTietMuon.setNgayTra(ngayTra.getTime());
                chiTietMuon.setBanDoc(phieuMuonReq.getBanDoc());
                chiTietMuon.setPhieuMuon(phieuMuon);

                DauSach dauSach = chiTietMuon.getSach().getDauSach();
                dauSach.setSoLuong((dauSach.getSoLuong() <= 0) ? 0 : dauSach.getSoLuong() - 1);

                chiTietMuonRepository.save(chiTietMuon);
                dauSachRepository.save(dauSach);
            });
            return phieuMuon;
        }catch (Exception e){
            throw new BadRequestException("Đã xảy ra lỗi");
        }
    }
}
