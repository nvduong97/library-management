package com.ptit.cnpm.controller;

import com.ptit.cnpm.security.JwtTokenUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class MuonSachControllerTest {

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
    public void homePage() throws Exception {
        this.mockMvc.perform(get("/")
                .header("Authorization", "Bearer " + this.accessToken))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Trang chủ")));
    }

    @Test
    public void getBanDoc() throws Exception {
        this.mockMvc.perform(get("/muon-sach")
                .header("Authorization", "Bearer " + this.accessToken))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Mượn sách")));
    }
}