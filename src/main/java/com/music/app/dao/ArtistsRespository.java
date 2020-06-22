package com.music.app.dao;

import java.util.List;
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
	@Query("Select c from Artists c where c.name like %:name%")
    List<Artists> findAllByName(String name); 
    
}