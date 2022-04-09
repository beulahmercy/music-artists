package com.music.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.app.dao.AlbumRespository;
import com.music.app.model.Albums;

/**
 * 
 * @author Beulah Mercy
 *
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRespository albumRepository;

	public Albums save(Albums albums) {
		return albumRepository.save(albums);
	}

	public Optional<Albums> findById(Long id) {
		return albumRepository.findById(id);
	}

	public List<Albums> findByArtistId(Long id, Sort sort) {
		return albumRepository.findByArtistId(id, sort);
	}
}
