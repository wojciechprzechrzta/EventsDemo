package com.przechu.eventsdemo.simple;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

@ToString
@Getter
public class GameStart {
    private LocalTime time;

    public GameStart() {
        this.time =  LocalTime.now();
    }
}
