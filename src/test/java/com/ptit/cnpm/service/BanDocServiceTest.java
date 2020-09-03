package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.repository.BanDocRepository;
import com.ptit.cnpm.repository.ChiTietMuonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Sql(scripts={"classpath:library.sql"})
@ActiveProfiles("test")
public class BanDocServiceTest {

    @Autowired
    BanDocRepository banDocRepository;

    @Autowired
    ChiTietMuonRepository chiTietMuonRepository;

    @Test
    public void getBanDoc() {
        assertEquals(1, 1);
    }

    @Test
    public void getBanDocById() {
        BanDoc banDoc = banDocRepository.findById(1).get();
        assertNotNull(banDoc);
        assertEquals("Duong", banDoc.getHoTen());
    }

}