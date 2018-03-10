package com.przechu.eventsdemo.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class MonitoredBankTranfer {
    private int id;
    private String name;
    private Double amount;
}
