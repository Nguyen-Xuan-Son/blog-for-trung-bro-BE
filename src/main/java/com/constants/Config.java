package com.constants;

import com.entity.IgnoreAuthenticateEntity;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static final int JWT_TOKEN_VALIDITY_TIME = 30 * 60 * 1000;
    public static final List<IgnoreAuthenticateEntity> API_IGNORE_AUTHENTICATION = new ArrayList<>();

    static {
        API_IGNORE_AUTHENTICATION.add(new IgnoreAuthenticateEntity("/login", "POST"));
        API_IGNORE_AUTHENTICATION.add(new IgnoreAuthenticateEntity("/remove-token", "GET"));
        API_IGNORE_AUTHENTICATION.add(new IgnoreAuthenticateEntity("/category", "GET"));
        API_IGNORE_AUTHENTICATION.add(new IgnoreAuthenticateEntity("/post", "GET"));
    }
}
