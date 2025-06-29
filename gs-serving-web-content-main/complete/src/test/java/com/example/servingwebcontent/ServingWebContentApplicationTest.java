package com.example.servingwebcontent;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ServingWebContentApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void indexPage_hasHereButton() throws Exception {
        mockMvc.perform(get("/index.html"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Here"))); // kiểm tra có nút "Here"
    }

    @Test
    public void homePage_hasMainButtons() throws Exception {
        mockMvc.perform(get("/home"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Music")))
            .andExpect(content().string(containsString("Playlist")))
            .andExpect(content().string(containsString("Album")));
    }

    @Test
    public void musicPageLoadsSuccessfully() throws Exception {
        mockMvc.perform(get("/music"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Music")));
    }

    @Test
    public void playlistPageLoadsSuccessfully() throws Exception {
        mockMvc.perform(get("/playlist"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Playlist")));
    }

    @Test
    public void albumPageLoadsSuccessfully() throws Exception {
        mockMvc.perform(get("/album"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Album")));
    }
}
