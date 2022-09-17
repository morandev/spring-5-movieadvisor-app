package com.morandev.movieadvisor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.morandev.movieadvisor.model.Film;
import com.morandev.movieadvisor.service.FilmQueryService;
import com.morandev.movieadvisor.service.FilmService;

@Component
public class MovieAdvisorRunApp {
	
	@Autowired
	private FilmService filmService;
	@Autowired
	private FilmQueryService filmQueryService;
	@Autowired
	private MovieAdvisorHelp advisorHelp;
	
	
	public void run(String... args) {
		
		// si no tenemos argumentos
		if (args.length < 1) {
			System.out.println("Error de sintaxis");
			System.out.println(advisorHelp.getHelpMsg());
		} else if (args.length == 1) { //tenemos 1 argumento

			switch ( args[0].toLowerCase() ) {
			case "-lg": /* listar generos */
				filmService.findAllGenres()
						   .forEach(System.out::println);
				break;
			case "-h": /* listar ayuda */
				System.out.println(advisorHelp.getHelpMsg());
				break;
			default:
				System.out.println("Error de sintaxis");
				System.out.println(advisorHelp.getHelpMsg());
			}
		} else if ( args.length % 2 != 0 ) {
			System.out.println("Error de sintaxis");
			System.out.println(advisorHelp.getHelpMsg());
		} else if ( args.length > 8 ) {
			System.out.println("Error de sintaxis");
			System.out.println(advisorHelp.getHelpMsg());
		} else {
			List<String[]> actualParams = new ArrayList<>();

			for (int i = 0; i < args.length; i+=2) {
				actualParams.add(new String[] { args[i], args[i+1] });
			}
			
			boolean error = false;

			for (String[] param : actualParams) {
				switch (param[0].toLowerCase()) {
				case "-ag":
					filmQueryService.anyGenre(param[1].split(","));
					break;
				case "-tg":
					filmQueryService.allGenres(param[1].split(","));
					break;
				case "-y":
					filmQueryService.year(param[1]);
					break;
				case "-b":
					String[] years = param[1].split(",");
					filmQueryService.betweenYears(years[0], years[1]);
					break;
				case "-t":
					filmQueryService.titleContains(param[1]);
					break;
				default: error = true;
						 System.out.println("Error de sintaxis");
						 System.out.println( advisorHelp.getHelpMsg() );
				}
				
			if (!error) {
				Collection<Film> result = filmQueryService.exec();
				
				System.out.printf("%s\t%-50s\t%s\t%s\n","ID","Título", "Año", "Géneros");
				
				if (result != null) {
					result.forEach(f -> System.out.printf("%s\t%-50s\t%s\t%s\n", f.getId(), f.getTitle(), f.getYear(), f.getGenres().stream().collect(Collectors.joining(", "))));
				} else {
					System.out.println("No hay películas que cumplan esos criterios. Lo sentimos");
				}
			}

		}

	}
	
}
	
}
