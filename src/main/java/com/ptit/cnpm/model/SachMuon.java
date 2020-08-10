package com.ptit.cnpm.model;

import com.ptit.cnpm.entity.ChiTietMuon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SachMuon {
    private int maBanDoc;
    private int maVach;
    private String hoTen;
    private Date ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private List<ChiTietMuon> sanhDangMuons;
    private List<ChiTietMuon> sanhDaMuons;
}
