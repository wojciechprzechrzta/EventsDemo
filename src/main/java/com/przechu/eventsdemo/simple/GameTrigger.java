package com.przechu.eventsdemo.simple;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Profile("simple")
@Component
@Slf4j
@RequiredArgsConstructor
public class GameTrigger {
    private final ApplicationEventPublisher publisher;

    public void startGame() {
        log.info("Starting game ...");
        this.publisher.publishEvent(new GameStart());
    }
}
