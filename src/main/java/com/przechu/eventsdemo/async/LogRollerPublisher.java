package com.przechu.eventsdemo.async;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("async")
@Slf4j
public class LogRollerPublisher {

    private final ApplicationEventPublisher publisher;

    public LogRollerPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void schedule(){
        log.info("[{}] Schedule log rolling", Thread.currentThread().getName());
        publisher.publishEvent(new StoreLogEvent());
    }

}
