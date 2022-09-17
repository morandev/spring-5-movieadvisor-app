package com.morandev.movieadvisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.morandev.movieadvisor.config.AppConfig;

public class MovieAdvisorApp {

	public static void main(String... args) {
		
		ApplicationContext appContext;
		appContext = new AnnotationConfigApplicationContext( AppConfig.class );
		
		MovieAdvisorRunApp advisorRunApp = appContext.getBean(MovieAdvisorRunApp.class);
		
		advisorRunApp.run(args);
		
		((AnnotationConfigApplicationContext) appContext).close();
		
	}
	
}
