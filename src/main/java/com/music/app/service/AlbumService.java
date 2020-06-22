package com.music.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import com.music.app.model.Albums;

/**
 * 
 * @author Beulah Mercy
 *
 */
public interface AlbumService {

	/**
	 * 
	 * @param albums
	 * @return saved or persisted the album data
	 */
	public Albums save(Albums albums);

	/**
	 * 
	 * @param id
	 * @return list of albums
	 */
	public Optional<Albums> findById(Long id);

	/**
	 * 
	 * @param id
	 * @param sort
	 * @return list of sorted artists
	 */
	public List<Albums> findByArtistId(Long id, Sort sort);
}
