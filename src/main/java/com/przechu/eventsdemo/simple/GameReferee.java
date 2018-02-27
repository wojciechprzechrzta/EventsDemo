package com.przechu.eventsdemo.simple;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Profile("simple")
@Component
@Slf4j
public class GameReferee {

    @EventListener
    public GameProgress onGameStarted(GameStart event){
        log.info("Game started at: {}", event.getTime());

        return new GameProgress();
    }

    @EventListener
    public GameEnd onGameContinue(GameProgress event){
        log.info("Game in progress");

        return new GameEnd();
    }

    @EventListener
    public void onEnd(GameEnd event){
        log.info("Game just ended: {}", event.getTime());
    }
}
