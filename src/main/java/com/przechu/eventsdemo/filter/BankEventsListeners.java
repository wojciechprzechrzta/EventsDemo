package com.przechu.eventsdemo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Profile("filter")
@Component
@Slf4j
public class BankEventsListeners {

    @EventListener(condition = "#event.amount > 10")
    public void trasholdExceeded(MoneyTransferEvent event) {
        log.error("Received threshold exceeded: {}", event);
    }

    @EventListener(condition = " #event.bankName == 'PKOBP' ")
    public void monitoredBankTranfer(MoneyTransferEvent event) {
        log.error("Received transfer by monitored bank: {}", event);
    }
}
