package com.ptit.cnpm.controller;

import com.ptit.cnpm.security.JwtTokenUtil;
import org.hamcrest.Matchers;
import org.junit.After;
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
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class BanDocControllerTest {

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
    public void getBanDocByIdPass() throws Exception {
        int  id = 1;
        this.mockMvc.perform(
                get("/api/ban-doc/{id}", id)
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.maBanDoc", Matchers.is(1)))
                .andExpect(jsonPath("$.hoTen", Matchers.is("Nguyễn Văn Dương")));
    }

    @Test
    public void getBanDocByIdFail() throws Exception {
        int  id = 1000;
        this.mockMvc.perform(
                get("/api/ban-doc/{id}", id)
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", Matchers.is("Dữ liệu yêu cầu không tồn tại")));
    }
}