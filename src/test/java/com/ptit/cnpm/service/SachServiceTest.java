package com.ptit.cnpm.service;

import com.ptit.cnpm.entity.Sach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SachServiceTest {

    @Autowired
    SachService sachService;

    @Test
    public void getSachByIdPass() {
        Sach sach = sachService.getSachById(1);
        assertNotNull(sach);
        assertEquals(134434, sach.getMaVach());
        assertEquals(1, sach.getMaSach());
    }

    @Test
    public void getSachByIdFail() {
        try {
            sachService.getSachById(1000);
        }catch (Exception e){
            assertEquals("Dữ liệu yêu cầu không tồn tại",e.getMessage());
        }
    }
}