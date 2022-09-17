package com.morandev.movieadvisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.morandev.movieadvisor.service.FilmQueryService;
import com.morandev.movieadvisor.service.FilmService;

@Component
public class MovieAdvisorRunApp {
	
	@Autowired
	private FilmService filmService;
	@Autowired
	private FilmQueryService filmQueryService;
	
	public void run(String... args) {
		
	}
	
}
