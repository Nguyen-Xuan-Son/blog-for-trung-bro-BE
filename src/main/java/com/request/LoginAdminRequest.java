package com.request;

import lombok.Data;

@Data
public class LoginAdminRequest {

    private String usernameOrEmail;

    private String password;

}
