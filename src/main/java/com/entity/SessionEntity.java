package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SessionEntity {

    private String token;

    private long lastRequestTime;

    private String userId;
}
