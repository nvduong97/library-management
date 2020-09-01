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
@Table(name = "phieu_muon")
public class PhieuMuon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maPhieuMuon;

    private int maVach;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_ban_doc")
    private BanDoc banDoc;

    @OneToMany(mappedBy = "phieuMuon")
    private List<ChiTietMuon> chiTietMuons;
}
