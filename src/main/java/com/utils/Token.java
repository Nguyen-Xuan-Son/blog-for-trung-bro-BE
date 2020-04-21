package com.utils;

import org.springframework.stereotype.Component;

@Component
public class Token {

    private final static int lengthToken = 30;

    public String generationToken() {
        return randomString(lengthToken);
    }

    private String randomString(int n) {
        String result = "";

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            result= sb.append(AlphaNumericString
                    .charAt(index))
                    .toString();
        }

        return result;
    }

}
