package com.ptit.cnpm.repository;

import com.ptit.cnpm.entity.BanDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BanDocRepository extends JpaRepository<BanDoc, Integer> {

    Optional<BanDoc> findByMaBanDocOrMaVach(int maBanDoc, int maVach);
}
