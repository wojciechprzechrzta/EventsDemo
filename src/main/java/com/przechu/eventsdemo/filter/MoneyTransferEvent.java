package com.przechu.eventsdemo.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class MoneyTransferEvent {
    private int id;
    private Double amount;
    private String bankName;
}
