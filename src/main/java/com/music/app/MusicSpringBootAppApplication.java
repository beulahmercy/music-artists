package com.music.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 
 * @author Beulah Mercy
 *
 */
@SpringBootApplication
@EnableCaching
public class MusicSpringBootAppApplication {

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MusicSpringBootAppApplication.class, args);
	}

}
