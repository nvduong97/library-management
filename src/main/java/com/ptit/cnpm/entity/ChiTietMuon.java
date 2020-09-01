package com.ptit.cnpm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chi_tiet_muon")
public class ChiTietMuon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maSachMuon;

    private int trangThai;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd")
    private Date ngayMuon;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd")
    private Date ngayTra;

    @ManyToOne()
    @JoinColumn(name = "ma_sach")
    private Sach sach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_phieu_muon")
    private PhieuMuon phieuMuon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_ban_doc")
    private BanDoc banDoc;

    @JsonIgnore
    public BanDoc getBanDoc() {
        return banDoc;
    }

    @JsonIgnore
    public PhieuMuon getPhieuMuon() {
        return phieuMuon;
    }

    @JsonIgnore
    public void setPhieuMuon(PhieuMuon phieuMuon) {
        this.phieuMuon = phieuMuon;
    }

    @JsonIgnore
    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }
}
