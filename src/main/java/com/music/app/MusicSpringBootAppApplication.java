package com.music.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Beulah Mercy
 *
 */
@SpringBootApplication
@EnableCaching
public class MusicSpringBootAppApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MusicSpringBootAppApplication.class, args);
	}


	@Bean
	public Map<String, String> getMap() {
		final Map<String, String> m = new HashMap<String, String>() {{
			put("a", "b");
			put("c", "d");
		}};

		return m;
	}

	@Override
	public void run(String... args) throws Exception {
		AccessBean a = context.getBean(AccessBean.class);
		a.display();
	}



}
