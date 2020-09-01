package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.NhanVien;
import com.ptit.cnpm.exception.DuplicateRecordException;
import com.ptit.cnpm.model.NhanVienReq;
import com.ptit.cnpm.repository.NhanVienRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    NhanVienRepository nhanVienRepository;

    public NhanVien createNhanVien(NhanVienReq req) {
        List<NhanVien> nhanViens = nhanVienRepository.findAll();
        for (NhanVien nhanVien: nhanViens) {
            if(nhanVien.getTaiKhoan().equals(req.getTaiKhoan())){
                throw  new DuplicateRecordException("Tài khoản đã tồn tại");
            }
        }
        NhanVien nhanVien = new NhanVien();
        nhanVien.setTaiKhoan(req.getTaiKhoan());
        // Hash password using BCrypt
        String hash = BCrypt.hashpw(req.getMatKhau(), BCrypt.gensalt(12));
        nhanVien.setMatKhau(hash);
        nhanVien.setRole("USER");
        nhanVienRepository.save(nhanVien);
        return nhanVien;
    }
}
