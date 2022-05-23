package com.music.app.service;

import com.music.app.dao.AlbumRespository;
import com.music.app.model.Albums;
import com.music.app.model.Artists;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestPropertySource(
        locations = "classpath:application-mysql.properties")
public class AlbumServiceTest {

    @InjectMocks
    private AlbumServiceImpl albumService;

    @Mock
    private AlbumRespository albumRespository;

    @BeforeEach
    void load(){

    }

    @Test
    void shouldSaveTheAlbum() {
        Albums a = new Albums();
        Artists b = new Artists();

        b.setName("Beulah");
        a.setArtist(b);
        a.setGenres(Arrays.asList("jazz"));

        Mockito.when(albumService.save(a)).thenReturn(a);

        Albums c = albumService.save(a);
        System.out.println(c.getId());
        Assert.assertNotNull(albumService.save(a));

    }
}