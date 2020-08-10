package com.ptit.cnpm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChiTietMuonReq {
    private int trangThai;
    private int maSach;
    private int maBanDoc;
}
