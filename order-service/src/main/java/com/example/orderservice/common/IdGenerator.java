package com.example.orderservice.common;

import org.springframework.stereotype.Component;

import java.util.UUID;

public class IdGenerator {

    public static UUID generateId() {
        return UUID.randomUUID();
    }
}
