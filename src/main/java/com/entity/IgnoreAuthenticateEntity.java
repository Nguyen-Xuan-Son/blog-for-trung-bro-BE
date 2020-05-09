package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IgnoreAuthenticateEntity {

    private String pathApi;

    private String methodApi;

}
