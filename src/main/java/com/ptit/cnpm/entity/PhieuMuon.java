package com.ptit.cnpm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "phieu_muon")
public class PhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maPhieuMuon;
    private int maVach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_ban_doc")
    private BanDoc banDoc;

    @OneToMany(mappedBy = "phieuMuon", fetch = FetchType.LAZY)
    private List<ChiTietMuon> chiTietMuons;

//    @JsonIgnore
//    public List<ChiTietMuon> getChiTietMuons() {
//        return chiTietMuons;
//    }
//
//    @JsonIgnore
//    public void setChiTietMuons(List<ChiTietMuon> chiTietMuons) {
//        this.chiTietMuons = chiTietMuons;
//    }
}
