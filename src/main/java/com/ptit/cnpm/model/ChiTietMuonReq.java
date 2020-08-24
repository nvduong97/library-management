package com.ptit.cnpm.model;

import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.entity.PhieuMuon;
import com.ptit.cnpm.entity.Sach;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChiTietMuonReq {
    private int maSachMuon;
    private int trangThai;
    private Date ngayMuon;
    private Date ngayTra;
    private Sach sach;
//    private PhieuMuonReq phieuMuon;
    private BanDoc banDoc;
}
