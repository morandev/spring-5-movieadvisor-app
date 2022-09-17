package com.morandev.movieadvisor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/* escanea todos los bean del packete movieadvisor y los mas abajo */
@ComponentScan(basePackages = "com.morandev.movieadvisor")
/* carga nuestro archivo de propiedades */
@PropertySource("classpath:/app.properties")
public class AppConfig {
	
	/* la idea es inyectar AppConfig en las clases que necesiten
	 * valores del archivo de propiedades */
	
	/* con la etiqueta value leemos las propiedades*/
	@Value("${file.path}")
	private String filePath;
	@Value("${file.csv.separator}")
	private String lineSeparator;
	@Value("${file.csv.list_separator}")
	private String listItemSeparator;
	
	public String getFilePath() {
		return filePath;
	}
	
	public String getLineSeparator() {
		return lineSeparator;
	}
	
	public String getListItemSeparator() {
		return listItemSeparator;
	}
}
