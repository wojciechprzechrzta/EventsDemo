package com.przechu.eventsdemo.generic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.przechu.eventsdemo.generic.EventTypes.*;

@Profile("generic")
@Component
@Slf4j
public class AgentPublisher {

    private final ApplicationEventPublisher publisher;

    public AgentPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


    public void start() {
        try {
            notifyStarted();

            TimeUnit.SECONDS.sleep(3);
            notifyActive();

            TimeUnit.SECONDS.sleep(3);
            notifyStopped();
        } catch (InterruptedException e) {
            log.error("Receive error: {}", e.getMessage());
        }
    }


    public void notifyStarted() {
        log.info("Agent publish - next state STARTED");
        this.publisher.publishEvent(new AgentEvent(AGENT_STARTED));
    }

    public void notifyActive() {
        log.info("Agent publish - next state ACTIVE");
        this.publisher.publishEvent(new AgentEvent(AGENT_ACTIVE));
    }

    public void notifyStopped() {
        log.info("Agent publish - next state STOPPED");
        this.publisher.publishEvent(new AgentEvent(AGENT_STOPPED));
    }


}
