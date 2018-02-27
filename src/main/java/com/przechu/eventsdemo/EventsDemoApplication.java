package com.przechu.eventsdemo;

import com.przechu.eventsdemo.simple.GameTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EventsDemoApplication implements CommandLineRunner {

	@Autowired(required = false)
	private GameTrigger gameTrigger;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(EventsDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello game");
		if(gameTrigger != null)
		   gameTrigger.startGame();
	}
}
