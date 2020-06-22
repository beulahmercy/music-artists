package com.music.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Beulah Mercy
 *
 */
@Entity
public class Albums {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@NotNull(message = "Please provide a album year of release")
	private Integer yearOfRelease;

	@NotEmpty(message = "Please provide a album title")
	private String title;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist_id")
	@JsonIgnore
	private Artists artist;

	@NotEmpty(message = "Please provide at leaset one genre")
	@ElementCollection(targetClass = String.class)
	private List<String> genres;

	public Albums() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(Integer yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public Artists getArtist() {
		return artist;
	}

	public void setArtist(Artists artist) {
		this.artist = artist;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Albums [id=" + id + ", yearOfRelease=" + yearOfRelease + ", title=" + title + ", artist=" + artist
				+ ", genres=" + genres + ", getId()=" + getId() + ", getYearOfRelease()=" + getYearOfRelease()
				+ ", getArtist()=" + getArtist() + ", getGenres()=" + getGenres() + ", getTitle()=" + getTitle()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
