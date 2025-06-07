# Group6_OOP_N02_term3_2025
Music Player

## Members

Đỗ Tùng Lâm 23010874

Github id: tunglvm

Trần Quốc Huy 23010184

Github id: Huybip

Đỗ Quỳnh Chi 23010618

Github id: quynchi16

## Objects

   Class Songs {

String Title

String Song ID

String Artis

String Type

Int Duration

}

   Class Album {

String Title

String ID

String Artist

String Songs

String Copyright

Int Duration

}

   Class Artist {

String Name

String ID

String Information

String Featuring

String Songs

String Album


}

Nội dung 01:

# Ứng Dụng Nghe Nhạc

## Mô Tả
Ứng dụng nghe nhạc được xây dựng bằng Java Spring Boot, cho phép người dùng quản lý bài hát và playlist. Ứng dụng cung cấp các chức năng như thêm, sửa, xóa bài hát, cũng như gán bài hát vào playlist.

## Yêu Cầu
- Java 11 hoặc cao hơn
- Spring Boot
- Maven hoặc Gradle
- Thư viện Thymeleaf (nếu sử dụng giao diện web)


## 🎵 Chức năng chính: Quản lý và Phát nhạc từ Album/Playlist

### 🧩 Mô tả chức năng:
Người dùng có thể tạo và quản lý Playlist hoặc Album nhạc. Sau đó, chọn một Album/Playlist để phát nhạc liên tục, với hỗ trợ các điều khiển cơ bản.

### 🔄 Phân rã chức năng:
- Tải danh sách Playlist từ thư mục hoặc dữ liệu có sẵn.
- Hiển thị các Album/Playlist.
- Người dùng chọn một danh sách để xem chi tiết và phát nhạc.
- Phát nhạc với điều khiển: Play, Pause, Next, Previous, Stop, Shuffle, Repeat.

### 👥 Phân công nhóm:
- Đỗ Quỳnh Chi: Xử lý tạo, sửa, xóa Album/Playlist.
- Đỗ Tùng Lâm: Hiển thị danh sách Playlist và bài hát bên trong.
- Trần Quốc Huy: Điều khiển phát nhạc từ Playlist.
- Cả nhóm: Gộp chức năng tổng thể và kiểm thử.

### 🗂 Lưu đồ thuật toán:

![Lưu đồ hoạt động của chức năng](https://github.com/user-attachments/assets/fd37f07f-0fbc-41b6-a718-de14e5077e92)


Nội dung 02:

![image](https://github.com/user-attachments/assets/ab0c18b4-c7b1-4907-88d4-b1ea96887b25)

Nội dung 03:

![Sơ đồ 1](https://github.com/user-attachments/assets/9a82e955-78e7-4e7b-a74f-56e460bc6144)


![Sơ đồ 2 - Activity Diagram](https://github.com/user-attachments/assets/bd6b42f0-a5c2-43cc-bde8-17b20c69a77f)


![Sơ đồ 3 - Sequence Diagram](https://github.com/user-attachments/assets/735a9b08-7ae9-4db0-99e5-00db09b9ec5e)


Kiểm thử CRUD cho n đối tượng: 


![image](https://github.com/user-attachments/assets/fe1349ec-3bba-4990-948a-95a618c9926a)

