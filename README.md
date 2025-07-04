# 🎵 ỨNG DỤNG NGHE NHẠC (SPRING BOOT)

## Group 6

### 📌 Tiêu đề bài tập lớn cuối kỳ: Ứng dụng nghe nhạc Music Player

---

## 👥 Thành viên nhóm

| Họ và tên       | MSSV      | GitHub ID     | Nhiệm vụ chính                                           |
|------------------|-----------|---------------|-----------------------------------------------------------|
| Đỗ Tùng Lâm       | 23010874  | tunglvm        | Hiển thị danh sách Playlist & bài hát & Album            |
| Trần Quốc Huy     | 23010184  | Huybip/WokHuy         | Điều khiển phát nhạc từ Playlist, Album và phát nhạc trực tiếp|
| Đỗ Quỳnh Chi      | 23010618  | quynchi16      | Tạo, sửa, xóa Album và Playlist và bài hát(Music)        |

---

## I. Phân tích đối tượng
---

### 1. Bài hát (Music)

#### Thuộc tính:
- Mã bài hát
- Tên bài hát
- Tác giả/Nhạc sĩ
- Thể loại
- File nhạc (đường dẫn trong `/static/assets/music/`)
- Thời lượng (tuỳ chọn)

#### Hành vi:
- Hiển thị thông tin
- Phát bài hát
- Gán vào Playlist hoặc Album

---

### 2. Playlist

#### Thuộc tính:
- Mã Playlist
- Tên Playlist
- Danh sách bài hát

#### Hành vi:
- Tạo Playlist mới
- Thêm/Xóa bài hát
- Phát toàn bộ Playlist

---

### 3. Album

#### Thuộc tính:
- Mã Album
- Tên Album
- Danh sách bài hát

#### Hành vi:
- Quản lý danh sách bài hát trong Album
- Phát toàn bộ Album

---

## II. Cấu trúc thư mục Project

music-player-springboot/
├── .vscode/
├── build/
├── gradle/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── servingwebcontent/
│       │               ├── controller/
│       │               │   ├── AlbumController.java
│       │               │   ├── PlaylistController.java
│       │               │   └── MusicController.java
│       │               ├── model/
│       │               │   ├── Album.java
│       │               │   ├── Playlist.java
│       │               │   └── Music.java
│       │               ├── repository/
│       │               │   ├── AlbumRepository.java
│       │               │   ├── PlaylistRepository.java
│       │               │   └── MusicRepository.java
│       │               ├── database/
│       │               │   └── AivenDatabaseConfig.java
│       │               └── ServingWebContentApplication.java
│       └── resources/
│           ├── static/
│           │   └── assets/
│           │       └── music/
│           │           └── file.mp3
│           ├── index.html
│           └── templates/
│               ├── playlist.html
│               ├── album.html
│               ├── music.html
│               ├── music_form.html
│               ├── music_play.html
│               ├── music_play2.html
│               ├── playlist_form.html
│               ├── playlist_musics.html
│               ├── album_form.html
│               └── album_musics.html
├── musicPlayer/
│   ├── bin/
│   └── src/
│       ├── musicPlayer/
│       │   ├── Album.java
│       │   ├── AlbumList.java
│       │   ├── App.java
│       │   ├── Artist.java
│       │   ├── ArtistList.java
│       │   ├── Playlist.java
│       │   ├── PlaylistList.java
│       │   ├── Song.java
│       │   ├── SongList.java
│       │   ├── User.java
│       │   ├── UserList.java
│       │   └── Operation/
│       │       ├── Copyright.java
│       │       ├── DisplaySongByArtist.java
│       │       ├── MusicLibrary.java
│       │       └── PlayingSong.java
│       └── Test/
├── README.md
---

## III. Hệ thống chức năng chính

---

| Chức năng                  | Mô tả chi tiết                                                      |
| -------------------------- | ------------------------------------------------------------------- |
| 🎵 Thêm nhạc               | Upload file nhạc vào thư mục `static/assets/music/`                 |
| 📁 Tạo Playlist/Album      | Người dùng tạo danh sách nhạc riêng                                 |
| ➕ Gán nhạc vào danh sách   | Chọn nhạc để gán vào Playlist hoặc Album                            |
| 📋 Hiển thị danh sách nhạc | Trang hiển thị danh sách playlist, album, nhạc trong từng danh sách |
| ▶️ Phát nhạc               | Phát từng bài hát hoặc toàn bộ Playlist/Album                       |
| 🔁 Shuffle/Repeat          | Cho phép phát ngẫu nhiên hoặc lặp lại                               |
| ⏭⏮ Điều khiển bài hát      | Next/Previous/Pause nhạc ngay trong trình phát                      |
| 🔍 Tìm kiếm                | Tìm kiếm bài hát, playlist và album theo từ khóa                         |

---

## IV. Lưu trữ dữ liệu

- Dữ liệu người dùng, bài hát, playlist và album được lưu trong **CSDL MySQL** (qua Aiven hoặc local).
- Tập tin nhạc được lưu trong thư mục: `resources/static/assets/music/`
- Các danh sách và dữ liệu liên quan được quản lý bằng các collection như `List<Music>`, `List<Playlist>`...

---

## V. Kiểm thử hệ thống

### 🧪 Music, Playlist, Album:
- Kiểm tra thêm/xóa bài hát, phát nhạc thành công
- Kiểm tra phát Playlist và Album theo thứ tự, ngẫu nhiên
- Kiểm tra điều hướng giữa các giao diện

### 🧪 UI:
- Kiểm thử giao diện bằng trình duyệt
- Kiểm tra khả năng hiển thị nhạc, playlist, album
- Thử các thao tác người dùng như thêm bài hát, play/pause, chọn danh sách

---

## VI. Yêu cầu môi trường

- Java 11 trở lên
- Spring Boot 3.x
- Gradle
- MySQL (có thể thay bằng Aiven MySQL)
- Trình duyệt để chạy giao diện người dùng

---

## VII. Cách chạy chương trình

### 1. Cấu hình CSDL 

- Để liên kết với MySQL Workbench, sử dụng các câu lệnh export trực tiếp từ terminal để kết nối.

## 2. Cách chạy chương và sử dụng

- Sử dụng ./gradlew bootRun
- Truy cập vào https://local.host:8080/

## Sơ đồ chức năng
1. Class Diagram
   
![image](https://github.com/user-attachments/assets/012b5636-36c9-4a92-b0b0-3ac5922c1358)


2. Sơ đồ chức năng phát nhạc và crud liên quan

![image](https://github.com/user-attachments/assets/6b64d6c4-c0c0-45f2-8d88-4679a12c4230)

3. Sơ đồ thêm, sửa, xóa album

![image](https://github.com/user-attachments/assets/8ae2b7dc-bb0c-4151-a26b-ae6a47606512)

4. Sơ đồ thêm, sửa, xóa playlist

![image](https://github.com/user-attachments/assets/72275d40-4a1d-4f92-8850-c4030c263734)

5. Sơ đồ khái quát chức năng của ứng dụng
   
![image](https://github.com/user-attachments/assets/df8915c7-36c7-4432-af54-eeb50b9d6e57)

6. Phát bài hát trong playlist
   
![image](https://github.com/user-attachments/assets/da3ff373-6b10-4907-bb55-05b6de626c15)

7. Phát bài hát trong Album
   
![image](https://github.com/user-attachments/assets/0b273ed0-316b-4a75-8e8f-32f2575ddfc3)

8. Lưu đồ thuật toán

![Lưu đồ hoạt động của chức năng](https://github.com/user-attachments/assets/fd37f07f-0fbc-41b6-a718-de14e5077e92)

## Màn hình giao diện

Giao diện truy cập vào phần chức năng: 

![image](https://github.com/user-attachments/assets/7166d245-7348-472f-b08e-59a10a3e8b09)


# Chức năng nổi bật
Phát nhạc trực tiếp từ danh sách nhạc
có thể tự tạo ra một Playlist cho riêng mình để nghe nhạc
cũng như là các Album có thể được tạo trực tiếp.
Tìm kiếm thông minh và nhanh chóng.

💡 Công nghệ sử dụng
Ngôn ngữ lập trình: Java
Mô hình hướng đối tượng (OOP)
Framework: Spring Boot
Quản lý luồng xử lý, cấu trúc theo mô hình MVC
Giao diện: Thymeleaf- HTML
Lưu trữ: File nhị phân
Cấu trúc dữ liệu: ArrayList, LinkedList, Map,…

📚 Tài liệu tham khảo
Slide bài giảng môn Lập trình Hướng Đối Tượng – GVHD: Nguyễn Lệ Thu
Java Docs – Oracle
Stack Overflow – Community








