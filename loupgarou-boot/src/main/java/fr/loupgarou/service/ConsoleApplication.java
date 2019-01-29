package fr.loupgarou.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ConsoleApplication implements CommandLineRunner {
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(" Projet Loup-Garou !");

		
	}
	
}
