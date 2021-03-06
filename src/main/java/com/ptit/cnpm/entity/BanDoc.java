package com.ptit.cnpm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ban_doc")
public class BanDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maBanDoc;

    private int maVach;

    private String hoTen;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd")
    private Date ngaySinh;

    private String diaChi;

    private String soDienThoai;

    @OneToMany(mappedBy = "banDoc", fetch = FetchType.LAZY)
    private List<ChiTietMuon> chiTietMuons;

    @OneToMany(mappedBy = "banDoc", fetch = FetchType.LAZY)
    private List<PhieuMuon> phieuMuons;

    @JsonIgnore
    public List<PhieuMuon> getPhieuMuons() {
        return phieuMuons;
    }

    @JsonIgnore
    public void setPhieuMuons(List<PhieuMuon> phieuMuons) {
        this.phieuMuons = phieuMuons;
    }

    @JsonIgnore
    public List<ChiTietMuon> getChiTietMuons() {
        return chiTietMuons;
    }

    @JsonIgnore
    public void setChiTietMuons(List<ChiTietMuon> chiTietMuons) {
        this.chiTietMuons = chiTietMuons;
    }
}
