package com.ptit.cnpm.controller;

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
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class NhanVienControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void signIn() throws Exception {
        this.mockMvc.perform(get("/dang-nhap"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Đăng nhập")));
    }

    @Test
    @Transactional
    public void createUserPass() throws Exception {
        String json = "{\"taiKhoan\":\"duongtest\",\"matKhau\":\"1234\"}";
        this.mockMvc.perform(
                post("/api/dang-ky")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taiKhoan", Matchers.is("duongtest")));
    }

    @Test
    public void loginPass() throws Exception {
        String json = "{\"taiKhoan\":\"duong\",\"matKhau\":\"1234\"}";
        this.mockMvc.perform(
                post("/api/dang-nhap")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void loginFail() throws Exception {
        String json = "{\"taiKhoan\":\"duong1234\",\"matKhau\":\"1234\"}";
        this.mockMvc.perform(
                post("/api/dang-nhap")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.message", Matchers.is("Sai thông tin đăng nhập")));
    }
}