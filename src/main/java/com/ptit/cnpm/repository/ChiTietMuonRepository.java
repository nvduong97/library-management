package com.ptit.cnpm.repository;

import com.ptit.cnpm.entity.ChiTietMuon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChiTietMuonRepository extends JpaRepository<ChiTietMuon, Integer> {

    @Query(value =
            "SELECT * FROM chi_tiet_muon c WHERE c.trang_thai = ?1 AND c.ma_ban_doc = ?2",
            nativeQuery = true)
    Optional<List<ChiTietMuon>> findByIdAndBanDoc(int trangThai, int maBD);

}
