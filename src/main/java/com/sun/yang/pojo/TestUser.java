package com.sun.yang.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TestUser {
    private long id;

    public TestUser(long id) {
        this.id = id;
    }
}
