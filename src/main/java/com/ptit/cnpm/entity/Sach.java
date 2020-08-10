package com.ptit.cnpm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maSach;
    private int maVach;

    @ManyToOne()
    @JoinColumn(name = "ma_dau_sach")
    private DauSach dauSach;

    @OneToMany(mappedBy = "sach", fetch = FetchType.LAZY)
    private List<ChiTietMuon> chiTietMuons;

    @JsonIgnore
    public List<ChiTietMuon> getChiTietMuons() {
        return chiTietMuons;
    }

    @JsonIgnore
    public void setChiTietMuons(List<ChiTietMuon> chiTietMuons) {
        this.chiTietMuons = chiTietMuons;
    }
}
