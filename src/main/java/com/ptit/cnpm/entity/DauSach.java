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
@Table(name = "dau_sach")
public class DauSach {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int maDauSach;

    private String tenDauSach;
    private String tacGia;

//    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd")
    private Date namXuatBan;

    private int giaBia;
    private int soLuong;
    private String moTa;

    @OneToMany(mappedBy = "dauSach", fetch = FetchType.LAZY)
    private List<Sach> sachs;

    @JsonIgnore
    public List<Sach> getSachs() {
        return sachs;
    }

    @JsonIgnore
    public void setSachs(List<Sach> sachs) {
        this.sachs = sachs;
    }
}
