package com.yk.theater.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerInput {
    private int customerId;
    private String tel;
    private long people;

    public CustomerInput(String tel, long people) {
        this.tel = tel;
        this.people = people;
    }
}
