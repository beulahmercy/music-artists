package com.music.app.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.music.app.model.Albums;

/**
 * 
 * @author Beulah Mercy
 *
 */
@Repository
public interface AlbumRespository extends JpaRepository<Albums, Long>{
	
	/**
	 * 
	 * @param artistId
	 * @param sort
	 * @return artists data for the given artistId and sort details
	 */
	List<Albums> findByArtistId(Long artistId, Sort sort);
}
