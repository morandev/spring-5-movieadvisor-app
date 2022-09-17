package com.morandev.movieadvisor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class MovieAdvisorHelp {

	private String helpMsg;
	
	@PostConstruct
	public void init(){
		try {
			
			// @formatter:off
			helpMsg = Files
						.lines( Paths.get(ResourceUtils.getFile("classpath:ayuda.txt").toURI() ) )
						.collect(Collectors.joining("\n"));
			// @formatter:on
			
		} catch( IOException e ) {
			System.err.println("Error subiendo el texto de ayuda");
			System.exit(-1);
		}
	}
	
	public String getHelpMsg() {
		return helpMsg;
	}
}
