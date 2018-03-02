package com.przechu.eventsdemo.async;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@ToString
public class StoreLogEvent {
    private LocalTime at;

    public StoreLogEvent() {
        this.at = LocalTime.now();
    }
}
