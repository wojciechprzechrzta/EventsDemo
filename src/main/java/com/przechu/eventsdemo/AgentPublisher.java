package com.przechu.eventsdemo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AgentPublisher {

    private final ApplicationEventPublisher publisher;

    public AgentPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void notifyStarted(){
        log.info("Agent publish - next state STARTED");
        this.publisher.publishEvent(new SimpleEvent(EventTypes.AGENT_STARTED));
    }

    public void notifyActive(){
        log.info("Agent publish - next state ACTIVE");
        this.publisher.publishEvent(new SimpleEvent(EventTypes.AGENT_ACTIVE));
    }

    public void notifyStopped(){
        log.info("Agent publish - next state STOPPED");
        this.publisher.publishEvent(new SimpleEvent(EventTypes.AGENT_STOPPED));
    }
}
