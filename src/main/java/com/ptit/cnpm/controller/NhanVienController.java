package com.ptit.cnpm.controller;

import com.ptit.cnpm.model.NhanVienReq;
import com.ptit.cnpm.security.JwtTokenUtil;
import com.ptit.cnpm.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("")
@Controller
public class NhanVienController {


    @Autowired
    public NhanVienService nhanVienService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final String NAME_TOKEN = "JWT_TOKEN";

    @GetMapping("/dang-nhap")
    public String signIn() {
        return "sign-in";
    }

    @PostMapping("/api/dang-ky")
    public ResponseEntity<?> createUser(@RequestBody NhanVienReq req) {
        return ResponseEntity.ok(nhanVienService.createNhanVien(req));
    }

    @PostMapping("/api/dang-nhap")
    public ResponseEntity<Object> login(@RequestBody NhanVienReq req,
                                   HttpServletResponse response) {
        String s;
        try {
            // Xác thực từ username và password.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getTaiKhoan(),
                            req.getMatKhau()
                    )
            );

            // Nếu không xảy ra exception tức là thông tin hợp lệ
            // Set thông tin authentication vào Security Context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Gen token
            String token = jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());

            Cookie jwtToken = new Cookie("jwt_token", token);
            jwtToken.setMaxAge(60 * 60 * 24);
            jwtToken.setPath("/");
            response.addCookie(jwtToken);
            s = "OK";
        }catch (Exception e){
            s = "FAIL";
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(s);
        }
        return ResponseEntity.ok(s);
    }

}
