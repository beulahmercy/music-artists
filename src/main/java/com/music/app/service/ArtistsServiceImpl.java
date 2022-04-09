package com.music.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.app.dao.ArtistsRespository;
import com.music.app.model.Artists;

/**
 * 
 * @author Beulah Mercy
 *
 */
@Service
@Transactional
public class ArtistsServiceImpl implements ArtistsService {
	
	@Autowired
	private ArtistsRespository artistsRepository;

	public Iterable<Artists> findAll(Sort sort) {
		return artistsRepository.findAll(sort);
	}

	public Page<Artists> findAll(Pageable pagable) {
		return artistsRepository.findAll(pagable);
	}

	@Override
	public Page<Artists> findAllByName(String name, Pageable pagable) {
		return artistsRepository.findAllByName(name, pagable);
	}

	public Artists save(Artists artists) {
		return artistsRepository.save(artists);
	}

	public Optional<Artists> findById(Long id) {
		return artistsRepository.findById(id);
	}

	public boolean existsById(Long id) {
		return artistsRepository.existsById(id);
	}
}
