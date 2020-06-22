package com.music.app.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.music.app.model.Artists;

/**
 * 
 * @author Beulah Mercy
 *
 */
public interface ArtistsService {

	/**
	 * 
	 * @param sort
	 * @return list of artists sorted by name
	 */
	public Iterable<Artists> findAll(Sort sort);

	/**
	 * 
	 * @param pagable
	 * @return list of artists with paging
	 */
	public Page<Artists> findAll(Pageable pagable);

	/**
	 * 
	 * @param artists
	 * @return saved artists data
	 */
	public Artists save(Artists artists);

	/**
	 * 
	 * @param id
	 * @return the artists data for the given id
	 */
	public Optional<Artists> findById(Long id);

	/**
	 * 
	 * @param id
	 * @return true if artists exists otherwise false 
	 */
	public boolean existsById(Long id);

}
