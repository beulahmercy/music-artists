package com.music.app.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 
 * @author Beulah Mercy
 *
 */
@Entity
public class Artists {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
		
	@OneToMany(mappedBy="artist", fetch=FetchType.LAZY)
	private List<Albums> albums;
	
	@NotEmpty(message = "Please provide a artist name")
	@Size(min = 1, max = 16, message = "Artist name must be equal to or greater than 1 and less than 16 characters")
	private String name;

	public Artists() {

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Albums> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Albums> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Artists [id=" + id + ", albums=" + albums + ", name=" + name + ", getId()=" + getId()
				//+ ", getAlbums()=" + getAlbums()
				+ ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
