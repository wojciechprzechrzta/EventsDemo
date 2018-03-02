package com.przechu.eventsdemo.generic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Profile("generic")
@Slf4j
@Component
public class AgentListener {

    @EventListener
    public void onActivate(AgentEvent<EventTypes> event){
        log.info("Received agent event: {}",event.getSource());
    }
}
