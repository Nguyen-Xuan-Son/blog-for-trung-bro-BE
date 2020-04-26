package com.controller;

import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/remove-token")
public class LogoutController {

    @GetMapping("")
    public ResponseData logout() {
        System.out.println("abc");
        return null;
    }

}
