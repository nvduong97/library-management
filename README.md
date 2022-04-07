# library-management
Hệ thống quản lý thư viện sử dụng spring boot and thymeleaf

# 1. Mô tả
Website Modul mượn sách cho "Hệ thống quản lý thư viện"
# 2. Các chức năng chính
- Đăng nhập.
- Truy cập trang chủ.
- Truy cập chức năng quản lý mượn sách.
  - Tìm bạn đọc theo mã.
  - Xem chi tiết thông tin bạn đọc.
  - Mượn sách: thêm sách theo mã, xác nhận mượn sách.
  - In phiếu mượn.
- Junit test.
# 3. Hướng dẫn cài đặt và chạy trên môi trường phát triển
- Clone repo: https://github.com/nvduong97/library-management
- Tải các thư viện maven, tại file pom.xml
- Cài đặt Xampp với:
  - Tạo Database: library
  - Username: root
  - Password:
- import data với file library.sql
- IDE: Intellij Community Version/hoặc Ultimate Version
- Run: LibraryManagementApplication.java
- Sử dụng trình duyệt bất kỳ(Chrome) để tương tác tại host: http://localhost:8081
- Đăng nhập vào hệ thống với: 
  - username: duongnv
  - pass: 1234
