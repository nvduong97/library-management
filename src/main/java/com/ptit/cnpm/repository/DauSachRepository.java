package com.ptit.cnpm.repository;

import com.ptit.cnpm.entity.DauSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DauSachRepository extends JpaRepository<DauSach, Integer> {
}
