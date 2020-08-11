package com.ptit.cnpm.repository;

import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.model.BanDocDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BanDocRepository extends JpaRepository<BanDoc, Integer> {

//    @Query("SELECT NEW com.ptit.cnpm.model.BanDocDTO() from BanDoc a)
//    Optional<BanDocDTO> findByIdOrMaVach(@Param("key") int key);
//
//    @Query("SELECT NEW com.smartosc.training.dto.AccountBankDTO(a.accountId,a.accountType," +
//            "b.bankId,a.accountNumber,a.status,b.code,b.legalName,a.modifiedBy,a.modifiedDatetime) FROM Account a " +
//            "JOIN Bank b ON a.bankId = b.bankId " +
//            "WHERE (b.code like %:searchValue%  " +
//            "OR b.legalName like %:searchValue% " +
//            "OR a.accountNumber LIKE %:searchValue%)")
//    Page<AccountBankDTO> findByAllAccountBankDTO(@Param("searchValue") String searchValue, Pageable pageable);

    Optional<BanDoc> findByMaBanDocOrMaVach(int maBanDoc, int maVach);
}
