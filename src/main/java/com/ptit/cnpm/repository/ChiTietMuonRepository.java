package com.ptit.cnpm.repository;

import com.ptit.cnpm.entity.ChiTietMuon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChiTietMuonRepository extends JpaRepository<ChiTietMuon, Integer> {
    Optional<List<ChiTietMuon>> findAllByTrangThai(int trangThai);
}
