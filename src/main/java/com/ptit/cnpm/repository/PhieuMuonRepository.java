package com.ptit.cnpm.repository;

import com.ptit.cnpm.entity.PhieuMuon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuMuonRepository extends JpaRepository<PhieuMuon, Integer> {

    @Query(value = "SELECT max(ma_vach) FROM phieu_muon", nativeQuery = true)
    Integer getMaVachMax();
}
