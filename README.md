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

## Chức Năng Chính
### 1. Quản Lý Bài Hát ([Đối tượng 01])
- **Thêm Bài Hát**: Cho phép người dùng thêm bài hát mới vào hệ thống.
- **Sửa Bài Hát**: Cung cấp chức năng sửa thông tin bài hát.
- **Xóa Bài Hát**: Cho phép người dùng xóa bài hát khỏi hệ thống.
- **Liệt Kê Bài Hát**: Hiển thị danh sách tất cả các bài hát và cho phép lọc theo thể loại.

### 2. Quản Lý Playlist ([Đối tượng 02])
- **Thêm Playlist**: Cho phép người dùng tạo playlist mới.
- **Sửa Playlist**: Cung cấp chức năng sửa thông tin playlist.
- **Xóa Playlist**: Cho phép người dùng xóa playlist khỏi hệ thống.

### 3. Gán Bài Hát vào Playlist
- Cho phép người dùng gán bài hát vào một playlist cụ thể.

## Lưu Trữ Dữ Liệu
- Dữ liệu bài hát và playlist được lưu trữ trong bộ nhớ sử dụng các Collection như `ArrayList`.
- Dữ liệu cũng được lưu trữ xuống file nhị phân để đảm bảo tính bền vững.


Nội dung 02:

![image](https://github.com/user-attachments/assets/ab0c18b4-c7b1-4907-88d4-b1ea96887b25)

Nội dung 03:

![Sơ đồ 1](https://github.com/user-attachments/assets/9a82e955-78e7-4e7b-a74f-56e460bc6144)


![Sơ đồ 2 - Activity Diagram](https://github.com/user-attachments/assets/bd6b42f0-a5c2-43cc-bde8-17b20c69a77f)


![Sơ đồ 3 - Sequence Diagram](https://github.com/user-attachments/assets/735a9b08-7ae9-4db0-99e5-00db09b9ec5e)




