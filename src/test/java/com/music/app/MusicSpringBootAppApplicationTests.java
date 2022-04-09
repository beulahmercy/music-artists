package com.music.app;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.music.app.dao.AlbumRespository;
import com.music.app.dao.ArtistsRespository;
import com.music.app.model.Albums;
import com.music.app.model.Artists;

@DataJpaTest
class MusicSpringBootAppApplicationTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private ArtistsRespository artistRepository;
	
	@Autowired
	private AlbumRespository albumRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
    public void doSaveArtists()
    {
		Artists artists = new Artists();
		artists.setName("john");
		
		
        artistRepository.save(artists);
         
        Assert.assertNotNull(artists.getId());
        
        Albums album = new Albums();
		album.setTitle("Country roads");
        album.setYearOfRelease(2019);
        List<String> genres = new ArrayList<>();
        genres.add("rap");
        genres.add("pop");
        album.setGenres(genres);
        album.setArtist(artists);
        albumRepository.save(album);
        
        Assert.assertNotNull(album.getId());
        
    }	
		
	@Test
	public void retireveArtists() {
		Optional<Artists> artists = artistRepository.findById(1L);
		logger.info("artistis -> {}", artists);
		logger.info("name -> {}", artists.get().getName());
		
		Assert.assertNotNull(artists.get());
	}

}
