package com.ptit.cnpm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptit.cnpm.entity.BanDoc;
import com.ptit.cnpm.entity.ChiTietMuon;
import com.ptit.cnpm.entity.PhieuMuon;
import com.ptit.cnpm.entity.Sach;
import com.ptit.cnpm.security.JwtTokenUtil;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class PhieuMuonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private String accessToken;

    @Before
    public void setUp(){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken("duong", "1234")
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        accessToken = jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());
    }

    @Test
    public void phieuMuon() throws Exception {
        this.mockMvc.perform(get("/phieu-muon")
                .header("Authorization", "Bearer " + this.accessToken))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Blank Page")));
    }

    @Test
    @Transactional
    public void luuPhieuMuonPass() throws Exception {
        PhieuMuon phieuMuon = new PhieuMuon();
        BanDoc banDoc = new BanDoc();
        Sach sach = new Sach();
        ChiTietMuon chiTietMuon = new ChiTietMuon();
        List<ChiTietMuon> chiTietMuons = new ArrayList<>();

        sach.setMaSach(1);
        banDoc.setMaBanDoc(1);

        chiTietMuon.setNgayMuon(new Date());
        chiTietMuon.setNgayTra(new Date());
        chiTietMuon.setSach(sach);
        chiTietMuons.add(chiTietMuon);

        phieuMuon.setBanDoc(banDoc);
        phieuMuon.setChiTietMuons(chiTietMuons);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/luu/phieu-muon").contentType(MediaType.APPLICATION_JSON).content(asJsonString(phieuMuon)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.banDoc.maBanDoc", Matchers.is(1)));
    }

    @Test
    @Transactional
    public void luuPhieuMuonFail() throws Exception {
        PhieuMuon phieuMuon = new PhieuMuon();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/luu/phieu-muon").contentType(MediaType.APPLICATION_JSON).content(asJsonString(phieuMuon)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}