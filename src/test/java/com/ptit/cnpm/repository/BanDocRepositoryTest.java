package com.ptit.cnpm.repository;

import com.ptit.cnpm.LibraryManagementApplication;
import com.ptit.cnpm.entity.BanDoc;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(scripts={"classpath:ban_doc.sql"})
@ActiveProfiles("test")
public class BanDocRepositoryTest {

    @Autowired
    BanDocRepository banDocRepository;

    @Test
    public void findAuthorById() {
//        banDocRepository.save(new BanDoc(1, 1111, "Duong", null,  "Ha Noi", "duong@gmail.com", null, null));
//        BanDoc banDoc = banDocRepository.findById(1).get();
//
//        assertNotNull(banDoc);
//        assertEquals("Duong", banDoc.getHoTen());
        Assertions.assertThat(banDocRepository.findAll()).hasSize(1);
    }

    @Test
    public void findByMaBanDocOrMaVach() {
    }
}