package com.przechu.eventsdemo.simple;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

@ToString
@Getter
public class GameEnd {
    private LocalTime time;

    public GameEnd() {
        this.time = LocalTime.now();
    }
}
