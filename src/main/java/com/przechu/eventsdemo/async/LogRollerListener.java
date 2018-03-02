package com.przechu.eventsdemo.async;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Profile("async")
@Component
@Slf4j
public class LogRollerListener {

    @Async
    @EventListener
    void handleLogs(StoreLogEvent event){
      log.info("[{}] Received event {}, storing logs", Thread.currentThread().getName(), event);
    }
}
