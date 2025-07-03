package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Music;
import com.example.servingwebcontent.model.Playlist;
import com.example.servingwebcontent.repository.AlbumRepository;
import com.example.servingwebcontent.repository.MusicRepository;
import com.example.servingwebcontent.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping({"", "/"})
    public String listMusic(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Music> musics;
        if (keyword != null && !keyword.trim().isEmpty()) {
            musics = musicRepository.findAll().stream()
                .filter(song -> song.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || song.getArtist().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        } else {
            musics = musicRepository.findAll();
        }
        model.addAttribute("musics", musics);
        model.addAttribute("keyword", keyword);
        return "music";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("music", new Music());
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("playlists", playlistRepository.findAll());
        return "music_form";
    }

    @PostMapping("/add")
    public String addMusic(@ModelAttribute Music music,
                       @RequestParam(value = "albumId", required = false) Long albumId,
                       @RequestParam(value = "playlistIds", required = false) List<Long> playlistIds,
                       Model model) {
        try {
            if (albumId != null) {
                albumRepository.findById(albumId).ifPresent(music::setAlbum);
            }
            // Lưu trước để có ID
            musicRepository.save(music);

            if (playlistIds != null && !playlistIds.isEmpty()) {
                List<Playlist> playlists = playlistRepository.findAllById(playlistIds);
                music.setPlaylists(playlists);
                for (Playlist playlist : playlists) {
                    if (!playlist.getMusics().contains(music)) {
                        playlist.getMusics().add(music);
                    }
                }
                // Lưu lại playlist để cập nhật bảng liên kết
                playlistRepository.saveAll(playlists);
                // Lưu lại music để cập nhật bảng liên kết
                musicRepository.save(music);
            } else {
                music.setPlaylists(new ArrayList<>());
                musicRepository.save(music);
            }
            return "redirect:/music";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi thêm bài hát: " + e.getMessage());
            model.addAttribute("music", music);
            model.addAttribute("albums", albumRepository.findAll());
            model.addAttribute("playlists", playlistRepository.findAll());
            return "music_form";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Music> music = musicRepository.findById(id);
        if (music.isPresent()) {
            model.addAttribute("music", music.get());
            model.addAttribute("albums", albumRepository.findAll());
            model.addAttribute("playlists", playlistRepository.findAll());
            return "music_form";
        }
        return "redirect:/music"; // Sửa lại ở đây
    }

    @PostMapping("/edit/{id}")
    public String editMusic(@PathVariable Long id,
                        @ModelAttribute Music music,
                        @RequestParam(value = "albumId", required = false) Long albumId,
                        @RequestParam(value = "playlistIds", required = false) List<Long> playlistIds,
                        Model model) {
        try {
            Optional<Music> musicOpt = musicRepository.findById(id);
            if (musicOpt.isPresent()) {
                Music existing = musicOpt.get();
                existing.setTitle(music.getTitle());
                existing.setArtist(music.getArtist());
                existing.setUrl(music.getUrl());
                existing.setCover(music.getCover());

                if (albumId != null) {
                    albumRepository.findById(albumId).ifPresent(existing::setAlbum);
                } else {
                    existing.setAlbum(null);
                }

                if (playlistIds != null && !playlistIds.isEmpty()) {
                    List<Playlist> playlists = playlistRepository.findAllById(playlistIds);
                    existing.setPlaylists(playlists);
                } else {
                    existing.setPlaylists(new ArrayList<>());
                }

                musicRepository.save(existing);
                return "redirect:/music"; // Sửa lại ở đây
            } else {
                model.addAttribute("error", "Không tìm thấy bài hát để sửa!");
                return "music_form";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi sửa bài hát: " + e.getMessage());
            model.addAttribute("music", music);
            model.addAttribute("albums", albumRepository.findAll());
            model.addAttribute("playlists", playlistRepository.findAll());
            return "music_form";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteMusic(@PathVariable Long id) {
        try {
            musicRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/music"; // Sửa lại ở đây
    }



    @GetMapping("/play/{id}")
    public String playMusic(@PathVariable Long id, Model model) {
        try {
            Optional<Music> music = musicRepository.findById(id);
            if (music.isPresent()) {
                model.addAttribute("music", music.get());
            } else {
                model.addAttribute("error", "Bài hát không tồn tại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi phát bài hát: " + e.getMessage());
        }
        return "music_play";
    }

    @GetMapping("/play/test/{id}")
    public String playMusic2(@PathVariable Long id, Model model) {
        Optional<Music> music = musicRepository.findById(id);
        if (music.isPresent()) {
            model.addAttribute("music", music.get());
        } else {
            model.addAttribute("error", "Bài hát không tồn tại!");
        }
        return "music_play2";
    }

    @GetMapping("/play")
    public String playFirstMusic(Model model) {
        try {
            Optional<Music> music = musicRepository.findAll().stream().findFirst();
            if (music.isPresent()) {
                model.addAttribute("music", music.get());
            } else {
                model.addAttribute("error", "Không tìm thấy bài hát.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi phát bài hát đầu tiên: " + e.getMessage());
        }
        return "music_play";
    }

    
}
