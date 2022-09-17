package com.morandev.movieadvisor.dao;

import java.util.Collection;

import com.morandev.movieadvisor.model.Film;

public interface FilmDao {
	Film findById(long id);
	Collection<Film> findAll();
	void insert(Film film);
	void edit(Film film);
	void delete(long id);
}
