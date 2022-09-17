package com.morandev.movieadvisor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/* escanea todos los bean del packete movieadvisor y los mas abajo */
@ComponentScan(basePackages = "com.morandev.movieadvisor")
public class AppConfig {

}
