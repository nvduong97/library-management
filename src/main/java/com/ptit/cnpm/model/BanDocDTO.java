package com.ptit.cnpm.model;

import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.entity.ChiTietMuon;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BanDocDTO {
    private BanDoc banDoc;
    private List<ChiTietMuon> sachDangMuons;
    private List<ChiTietMuon> sachDaMuons;
}
