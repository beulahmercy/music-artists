package com.music.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccessBean {

		@Autowired
		private Map<String, String> m;

		public void display(){
			for(Map.Entry e: m.entrySet()) {
				System.out.println(e.getKey());
			}
		}
	}