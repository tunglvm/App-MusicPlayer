package com.example.servingwebcontent.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.example.servingwebcontent.model.Music; // Thêm dòng này

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cover;

    @OneToMany(mappedBy = "album")
    private List<Music> musics = new ArrayList<>();

    // Constructor
    public Album() {}

    public Album(String name, String cover) {
        this.name = name;
        this.cover = cover;
    }

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCover() { return cover; }
    public void setCover(String cover) { this.cover = cover; }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }
}
