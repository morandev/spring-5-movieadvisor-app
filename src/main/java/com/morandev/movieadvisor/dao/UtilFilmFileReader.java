package com.morandev.movieadvisor.dao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ResourceUtils;

import com.morandev.movieadvisor.Film;

public class UtilFilmFileReader {
	public static List<Film> readFile(final String path, 
									  final String separator,
									  final String listSeparator) throws Exception {
		
		List<Film> results = new ArrayList<>();
		
		results = Files.lines( Paths.get( ResourceUtils.getFile(path).toURI() ) )
			.skip(1)
			.map( ln -> {
				String [] values = ln.split(separator);
				//TODO: borrar este debugger
				System.out.println("Los valores de la linea spliteada: ");
				System.out.println( Arrays.toString(values) + "\n");
				
				return new Film(Long.parseLong(values[0]), values[1], values[2],
						Arrays.asList(values[3].split(listSeparator)));
			})
			.collect( Collectors.toList());
		
		return results;
	}
}
