package com.przechu.eventsdemo.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Profile("filter")
@Component
@RequiredArgsConstructor
@Slf4j
public class MoneyTransferPublisher {
    final int UPPER_BOUND = 20;
    private final ApplicationEventPublisher publisher;

    public void nextTransfer(MoneyTransferEvent event) {
        log.info("Notify transfer: {}", event);
        publisher.publishEvent(event);
    }

    public void simulateTransfers() {
        for (int nextId = 0; nextId < 100; nextId++) {
            nextTransfer(new MoneyTransferEvent(nextId, nextAmount(), nextBank(nextId)));
        }
    }

    private double nextAmount() {
        return new Random().nextDouble() * UPPER_BOUND;
    }

    private String nextBank(int nextId) {
        final List<String> names = Arrays.asList("BANK-OF-AMERICA", "CREDIT-AGRICOLE", "PKOBP");
        return names.get(nextId % 3);
    }
}
