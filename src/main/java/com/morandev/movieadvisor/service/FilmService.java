package com.morandev.movieadvisor.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morandev.movieadvisor.Film;
import com.morandev.movieadvisor.dao.FilmDao;

@Service
public class FilmService {
	
	@Autowired
	private FilmDao filmDao;
	@Autowired
	private FilmQueryService filmQueryService;
	
	public Collection<String> findAllGenres() {
		List<String> genres = null;
	
		// formatter:off
		genres = filmDao.findAll()
				        .stream()
				        .map( f -> f.getGenres() )
				        .flatMap( lista -> lista.stream() )
				        .distinct()
				        .sorted()
				        .collect( Collectors.toList() );
		// formatter:on
		return genres;
	}
	
	public Collection<Film> findByAnyGenre(String... genres) {
		return filmQueryService.anyGenre( genres ).exec();
	}


	public Collection<Film>  findByAllGenres(String... genres) {
		return filmQueryService.allGenres( genres ).exec();
	}


	public Collection<Film>  findByyear(String year) {
		return filmQueryService.year( year ).exec();
	}


	public Collection<Film>  findBetweenYears(String from, String to) {
		return filmQueryService.betweenYears( from , to ).exec();	}


	public Collection<Film>  findByTitleContains(String title) {
		return filmQueryService.titleContains( title ).exec();
	}

}
