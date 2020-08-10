package com.ptit.cnpm.model;

import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.entity.ChiTietMuon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhieuMuon {
    private int maPhieuMuon;
    private int maVach;
    private BanDoc banDoc;
    private List<ChiTietMuon> chiTietMuons;
}
