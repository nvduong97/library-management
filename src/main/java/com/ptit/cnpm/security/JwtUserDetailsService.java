package com.ptit.cnpm.security;

import com.ptit.cnpm.entity.NhanVien;
import com.ptit.cnpm.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public UserDetails loadUserByUsername(String acc) throws UsernameNotFoundException {
        NhanVien nhanVien = nhanVienRepository.findByTaiKhoan(acc);
        if (nhanVien != null) {
            return new CustomUserDetails(nhanVien);
        }
        return null;
    }
}
