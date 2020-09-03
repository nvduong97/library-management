CREATE TABLE `ban_doc` (
  `ma_ban_doc` int(11) NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `ho_ten` varchar(255) DEFAULT NULL,
  `ma_vach` int(11) NOT NULL,
  `ngay_sinh` datetime DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL
);
INSERT INTO `ban_doc` (`ma_ban_doc`, `dia_chi`, `ho_ten`, `ma_vach`, `ngay_sinh`, `so_dien_thoai`) VALUES
(1, 'Ha Noi', 'Duong', 1111, NULL, 'duong@gmail.com');

