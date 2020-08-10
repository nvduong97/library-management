package com.ptit.cnpm.repository;

import com.ptit.cnpm.entity.BanDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanDocRepository extends JpaRepository<BanDoc, Integer> {
}
