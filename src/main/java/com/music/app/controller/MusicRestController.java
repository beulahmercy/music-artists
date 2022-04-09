package com.music.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.music.app.aspect.trace.Traceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.music.app.exception.ResourceNotFoundException;
import com.music.app.model.Albums;
import com.music.app.model.Artists;
import com.music.app.service.AlbumService;
import com.music.app.service.ArtistsService;

/**
 * 
 * @author Beulah Mercy
 *
 */
@RestController
@RequestMapping(path="/music")
public class MusicRestController {
	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private ArtistsService artistsService;

	@Autowired
	private AlbumService albumService;

	/**
	 * 
	 * @return string
	 */
	@GetMapping("/")
	public String home() {
		return "music artists";
	}

	/**
	 * 
	 * @return list of artists
	 */
	@GetMapping("/artists")
	public Iterable<Artists> getArtists() {
		Iterable<Artists> artists = artistsService.findAll(Sort.by("name"));
		return artists;
	}

	/**
	 * 
	 * @param artistId
	 * @return specific artist details based on given artistId
	 */
	@GetMapping("/artists/{artistId}/albums")
	@Traceable
	public List<Albums> getArtistsAlbums(@PathVariable("artistId") Long artistId) {
		Sort sort = Sort.by(Sort.Order.asc("artist.name"), Sort.Order.desc("yearOfRelease"));
		List<Albums> albums = albumService.findByArtistId(artistId, sort);
		return albums;
	}

	/**
	 * 
	 * @param pageNo
	 * @return list of artists with 3 records per page
	 */
	@GetMapping("/artists/pages/{pageNo}")
	public List<Artists> getArtistsPaging(@PathVariable("pageNo") int pageNo) {
		Pageable paging = PageRequest.of(pageNo, 3, Sort.by("name"));
		
		Page<Artists> pagedResult = artistsService.findAllByName("john", paging);
		
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			throw new ResourceNotFoundException(String.format("No records to display for this page %s", pageNo));
		}
	}

	/**
	 * 
	 * @param artists
	 * @return saved artists data
	 */
	@PostMapping("/artists")
	public Artists createArtists(@Valid @RequestBody Artists artists) {
		Artists savedArtists = artistsService.save(artists);
		return savedArtists;
	}

	/**
	 * 
	 * @param albums
	 * @param id
	 * @return saved artists album data for the given artistId
	 * @throws ResourceNotFoundException
	 */
	@PostMapping("/artists/{artistId}/albums")
	public Albums createAlbumArtists(@Valid @RequestBody Albums albums, @PathVariable("artistId") Long id)
			throws ResourceNotFoundException {
		return artistsService.findById(id).map(artist -> {
			albums.setArtist(artist);
			return albumService.save(albums);
		}).orElseThrow(() -> new ResourceNotFoundException(String.format("Artists with ID %s not found", id)));
	}

	/**
	 * 
	 * @param artists
	 * @param artistId
	 * @return updated artists data
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/artists/{artistId}")
	public ResponseEntity<Object> updateArtists(@Valid @RequestBody Artists artists, @PathVariable("artistId") Long artistId)
			throws ResourceNotFoundException {

		if (!artistsService.existsById(artistId)) {
			throw new ResourceNotFoundException(String.format("Artists with ID %s not found", artistId));
		}

		Artists updateArtists = artistsService.findById(artistId).get();
		updateArtists.setName(artists.getName());
		artistsService.save(updateArtists);

		return ResponseEntity.ok(updateArtists);
	}

	/**
	 * 
	 * @param albums
	 * @param artistId
	 * @param albumId
	 * @return updated artists album data for the given artistId
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/artists/{artistId}/albums/{albumId}")
	public Albums updateArtistAlbums(@Valid @RequestBody Albums albums, @PathVariable("artistId") Long artistId,
			@PathVariable("albumId") Long albumId) throws ResourceNotFoundException {

		if (!artistsService.existsById(artistId)) {
			throw new ResourceNotFoundException(String.format("Artists with ID %s not found", artistId));
		}

		return albumService.findById(albumId).map(album -> {
			album.setTitle(albums.getTitle());
			album.setYearOfRelease(album.getYearOfRelease());
			album.setGenres(albums.getGenres());
			return albumService.save(album);
		}).orElseThrow(() -> new ResourceNotFoundException(String.format("Albums with ID %s not found", albumId)));
	}

	@DeleteMapping("/clear/cache")
	public void clearCache(){
		for(String name:cacheManager.getCacheNames()){
			cacheManager.getCache(name).clear();
		}
	}
}
