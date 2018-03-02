package com.przechu.eventsdemo;

import com.przechu.eventsdemo.async.LogRollerPublisher;
import com.przechu.eventsdemo.generic.AgentPublisher;
import com.przechu.eventsdemo.simple.GameTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;

@SpringBootApplication
public class EventsDemoApplication implements CommandLineRunner {

    @Autowired(required = false)
    private GameTrigger gameTrigger;

    @Autowired(required = false)
    private AgentPublisher agent;

    @Autowired(required = false)
    private LogRollerPublisher logRollerPublisher;


    public static void main(String[] args) throws IOException {
        SpringApplication.run(EventsDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello game");
        if (gameTrigger != null)
            gameTrigger.startGame();

        if (agent != null) {
            agent.start();
        }

        if(logRollerPublisher != null){
            logRollerPublisher.schedule();
        }

    }

    @Profile("async")
    @Configuration
    @EnableAsync
    class  AsyncConfig {
    }
}
