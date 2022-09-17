package com.morandev.movieadvisor.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.morandev.movieadvisor.Film;
import com.morandev.movieadvisor.config.AppConfig;

/* bean repository */
@Repository
public class FilmDaoImplMemory implements FilmDao {
	
	/* Inyectamos la dependencia de AppConfig*/
	@Autowired
	private AppConfig appConfig;
	
	private List<Film> movies = new ArrayList<>();
	
	
	public void init() throws Exception {
		movies = UtilFilmFileReader.readFile( appConfig.getFilePath(),
											appConfig.getLineSeparator(),
											appConfig.getListItemSeparator());
	}
	
	@Override
	public Film findById(long id) {
		
		Optional<Film> filmFromData = movies.stream()
											.filter( mv -> mv.getId() == id )
											.findFirst();
		
		return filmFromData.orElse( null );
	}

	@Override
	public Collection<Film> findAll() {
		return movies;
	}

	@Override
	public void insert(Film film) {
		movies.add(film);
	}

	@Override
	public void edit(Film film) {
		int idx = movies.indexOf( this.findById( film.getId() ) );
		if( idx != -1 ) movies.set( idx, film );
	}

	@Override
	public void delete(long id) {
		int idx = movies.indexOf( this.findById( id ) );
		if( idx != -1 ) movies.remove( idx );
	}

}
