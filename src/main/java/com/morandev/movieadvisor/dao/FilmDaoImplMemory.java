package com.morandev.movieadvisor.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Film> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Film film) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Film film) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
