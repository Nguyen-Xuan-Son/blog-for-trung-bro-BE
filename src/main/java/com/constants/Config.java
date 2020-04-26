package com.constants;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static final int JWT_TOKEN_VALIDITY_TIME = 30 * 60 * 1000;
    public static final List<String> API_IGNORE_AUTHENTICATION = new ArrayList<>();

    static {
        API_IGNORE_AUTHENTICATION.add("/login");
        API_IGNORE_AUTHENTICATION.add("/logout");
        API_IGNORE_AUTHENTICATION.add("/post");
    }
}
