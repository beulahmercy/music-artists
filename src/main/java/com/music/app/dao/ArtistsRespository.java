package com.music.app.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.music.app.model.Artists;

/**
 * 
 * @author Beulah Mercy
 *
 */
@Repository
public interface ArtistsRespository extends PagingAndSortingRepository<Artists, Long> {
 
	/**
	 * 
	 * @param name
	 * @return artists data filtered by name in ascending order
	 */
	@Cacheable(value="artists")
	@Query("Select c from Artists c where c.name like %:name%")
	Page<Artists> findAllByName(String name, Pageable pageable);
    
}