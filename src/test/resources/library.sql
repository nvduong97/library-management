--
-- Cấu trúc bảng cho bảng `ban_doc`
--
CREATE TABLE `ban_doc` (
  `ma_ban_doc` int(11) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `ho_ten` varchar(255) DEFAULT NULL,
  `ma_vach` int(11) NOT NULL,
  `ngay_sinh` datetime DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL
);

--
-- Đang đổ dữ liệu cho bảng `ban_doc`
--

INSERT INTO `ban_doc` (`ma_ban_doc`, `dia_chi`, `ho_ten`, `ma_vach`, `ngay_sinh`, `so_dien_thoai`) VALUES
(1, 'Ha Noi', 'Duong', 1111, NULL, 'duong@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_muon`
--

CREATE TABLE `chi_tiet_muon` (
  `ma_sach_muon` int(11) NOT NULL,
  `ngay_muon` datetime DEFAULT NULL,
  `ngay_tra` datetime DEFAULT NULL,
  `trang_thai` int(11) NOT NULL,
  `ma_ban_doc` int(11) DEFAULT NULL,
  `ma_phieu_muon` int(11) DEFAULT NULL,
  `ma_sach` int(11) DEFAULT NULL
);

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_muon`
--

INSERT INTO `chi_tiet_muon` (`ma_sach_muon`, `ngay_muon`, `ngay_tra`, `trang_thai`, `ma_ban_doc`, `ma_phieu_muon`, `ma_sach`) VALUES
(1, '2020-08-31 00:00:00', '2020-09-30 00:00:00', 1, 1, 4, 1),
(2, '2020-08-31 00:00:00', '2020-09-30 00:00:00', 1, 1, 3, 2),
(3, '2020-08-31 00:00:00', '2020-09-30 00:00:00', 1, 1, 3, 3),
(4, '2020-08-31 00:00:00', '2020-09-30 00:00:00', 1, 1, 4, 4),
(5, '2020-08-31 00:00:00', '2020-09-30 00:00:00', 0, 1, 5, 5),
(6, '2020-09-01 00:00:00', '2020-10-01 00:00:00', 0, 1, 5, 2),
(7, '2020-09-03 00:00:00', '2020-10-03 00:00:00', 0, 1, 5, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dau_sach`
--

CREATE TABLE `dau_sach` (
  `ma_dau_sach` int(11) NOT NULL,
  `gia_bia` int(11) NOT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `nam_xuat_ban` datetime DEFAULT NULL,
  `so_luong` int(11) NOT NULL,
  `tac_gia` varchar(255) DEFAULT NULL,
  `ten_dau_sach` varchar(255) DEFAULT NULL
);

--
-- Đang đổ dữ liệu cho bảng `dau_sach`
--

INSERT INTO `dau_sach` (`ma_dau_sach`, `gia_bia`, `mo_ta`, `nam_xuat_ban`, `so_luong`, `tac_gia`, `ten_dau_sach`) VALUES
(1, 100000, '', '2020-08-03 13:50:47', 209, 'Lê Tiến Hải', 'Kĩ thuật vi xử lý'),
(2, 100000, '', '2020-08-08 13:50:53', 209, 'Đỗ Hồng Hạnh', 'Hệ Điều hành'),
(3, 100000, '', '2020-08-19 13:50:57', 209, 'Đậu Minh Tuấn', 'Kĩ thuật đồ họa'),
(4, 100000, '', '2020-08-19 13:50:59', 209, 'Hồ Viết Tùng', 'Xử lý ảnh'),
(5, 100000, '', '2020-08-04 13:51:02', 209, 'Kim Tiến Thành', 'Xây dựng các hệ thống nhúng');

--
-- Cấu trúc bảng cho bảng `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `manv` int(11) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `tai_khoan` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `role` varchar(255) NOT NULL DEFAULT 'USER'
);

--
-- Đang đổ dữ liệu cho bảng `nhan_vien`
--

INSERT INTO `nhan_vien` (`manv`, `dia_chi`, `mat_khau`, `so_dien_thoai`, `tai_khoan`, `ten`, `role`) VALUES
(1, '345 Trần Phú, Hà Đông, Hà Nội', '1234', '0978123666', 'duongnv', 'Nguyễn Văn Dương', 'USER'),
(2, '345 Trần Phú, Hà Đông, Hà Nội', '$2a$12$gsiF0mq8AI9zy/pG9lwceeVCju7JRY4gKDZGSRHUqoJp8KgDtpnE2', '0978123666', 'duong', 'Nguyễn Văn Dương', 'USER'),
(3, NULL, '$2a$12$0Z8LrUucKfq7gfeJZEFMtOnQ7QVlM950uhz5IgsfDbS2QtuaRUcLu', NULL, 'duongduong', NULL, 'USER'),
(4, NULL, '$2a$12$/nhik3bj2BwA4/vyKGrrjuRNWKwq3Y8iLp2aLHukMw7AdvaxOAP4O', NULL, '', NULL, 'USER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_muon`
--

CREATE TABLE `phieu_muon` (
  `ma_phieu_muon` int(11) NOT NULL,
  `ma_vach` int(11) NOT NULL,
  `ma_ban_doc` int(11) DEFAULT NULL
);

--
-- Đang đổ dữ liệu cho bảng `phieu_muon`
--

INSERT INTO `phieu_muon` (`ma_phieu_muon`, `ma_vach`, `ma_ban_doc`) VALUES
(1, 12313, 1),
(2, 12313, 1),
(3, 12313, 1),
(4, 12313, 1),
(5, 12313, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `ma_sach` int(11) NOT NULL,
  `ma_vach` int(11) NOT NULL,
  `ma_dau_sach` int(11) DEFAULT NULL
);

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`ma_sach`, `ma_vach`, `ma_dau_sach`) VALUES
(1, 134434, 1),
(2, 123456, 2),
(3, 678675, 3),
(4, 547868, 4),
(5, 678097, 5);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban_doc`
--
ALTER TABLE `ban_doc`
  ADD PRIMARY KEY (`ma_ban_doc`);

ALTER TABLE `dau_sach`
  ADD PRIMARY KEY (`ma_dau_sach`);

--
-- Chỉ mục cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`manv`);

--
-- Chỉ mục cho bảng `phieu_muon`
--
ALTER TABLE `phieu_muon`
  ADD PRIMARY KEY (`ma_phieu_muon`),
  ADD KEY `FKbsoyopkia2mflgkwuprccooam` (`ma_ban_doc`);

--
-- Chỉ mục cho bảng `sach`
--
-- ALTER TABLE `sach`
--   ADD PRIMARY KEY (`ma_sach`),
--   ADD KEY `FKibu48m3ji5kwc79sx3k29ka7` (`ma_dau_sach`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ban_doc`
-- --
-- ALTER TABLE `ban_doc`
--   MODIFY `ma_ban_doc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- --
-- -- AUTO_INCREMENT cho bảng `chi_tiet_muon`
-- --
-- ALTER TABLE `chi_tiet_muon`
--   MODIFY `ma_sach_muon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- --
-- -- AUTO_INCREMENT cho bảng `dau_sach`
-- --
-- ALTER TABLE `dau_sach`
--   MODIFY `ma_dau_sach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- --
-- -- AUTO_INCREMENT cho bảng `nhan_vien`
-- --
-- ALTER TABLE `nhan_vien`
--   MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- --
-- -- AUTO_INCREMENT cho bảng `phieu_muon`
-- --
-- ALTER TABLE `phieu_muon`
--   MODIFY `ma_phieu_muon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- --
-- -- AUTO_INCREMENT cho bảng `sach`
-- --
-- ALTER TABLE `sach`
--   MODIFY `ma_sach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chi_tiet_muon`
--
ALTER TABLE `chi_tiet_muon`
  ADD CONSTRAINT `FK3m8heedrkk2ycehfu4udkxkp3` FOREIGN KEY (`ma_sach`) REFERENCES `sach` (`ma_sach`),
  ADD CONSTRAINT `FKbq2ooe839hpdhgwcp6ha6i43n` FOREIGN KEY (`ma_ban_doc`) REFERENCES `ban_doc` (`ma_ban_doc`),
  ADD CONSTRAINT `FKh6whkv80f0wx89qx8qryy8gp3` FOREIGN KEY (`ma_phieu_muon`) REFERENCES `phieu_muon` (`ma_phieu_muon`);

--
-- Các ràng buộc cho bảng `phieu_muon`
--
ALTER TABLE `phieu_muon`
  ADD CONSTRAINT `FKbsoyopkia2mflgkwuprccooam` FOREIGN KEY (`ma_ban_doc`) REFERENCES `ban_doc` (`ma_ban_doc`);

--
-- Các ràng buộc cho bảng `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `FKibu48m3ji5kwc79sx3k29ka7` FOREIGN KEY (`ma_dau_sach`) REFERENCES `dau_sach` (`ma_dau_sach`);
COMMIT;
