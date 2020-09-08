package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.model.BanDocDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class BanDocServiceTest {

    @Autowired
    BanDocService banDocService;

    @Test
    public void getBanDocPass() {
        BanDocDTO banDocDTO = banDocService.getBanDoc(1);
        assertNotNull(banDocDTO);
        assertEquals("Nguyễn Văn Dương", banDocDTO.getBanDoc().getHoTen());
//        assertEquals(2, banDocDTO.getSachDaMuons().size());
//        assertEquals(2, banDocDTO.getSachDangMuons().size());
    }

    @Test
    public void getBanDocFail() {
        BanDocDTO banDocDTO = banDocService.getBanDoc(1000);
        assertNull(banDocDTO.getBanDoc());
        assertNull(banDocDTO.getSachDaMuons());
        assertNull(banDocDTO.getSachDangMuons());
    }

    @Test
    public void getBanDocByIdPass() {
        BanDoc banDoc = banDocService.getBanDocById(1);
        assertNotNull(banDoc);
        assertEquals("Nguyễn Văn Dương", banDoc.getHoTen());
    }

    @Test
    public void getBanDocByIdFail() {
        try {
            banDocService.getBanDocById(1000);
        }catch (Exception e){
            assertEquals("Dữ liệu yêu cầu không tồn tại",e.getMessage());
        }
    }

}