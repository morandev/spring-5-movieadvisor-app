package com.morandev.movieadvisor;

import java.util.List;
import java.util.Objects;

public class Film {
	private Long id;
	private String year;
	private String title;
	private List<String> genres;
	
	public Film() {
		// TODO Auto-generated constructor stub
	}

	public Film(Long id, String year, String title, List<String> genres) {
		this.id = id;
		this.year = year;
		this.title = title;
		this.genres = genres;
	}
	
	public List<String> getGenres() {
		return genres;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(genres, id, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(genres, other.genres) && Objects.equals(id, other.id)
				&& Objects.equals(title, other.title) && Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", year=" + year + ", title=" + title + ", genres=" + genres + "]";
	}
	
	
}
