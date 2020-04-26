package com.controller;

import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/logout")
public class LogoutController extends BaseController {

    @GetMapping()
    public ResponseData logout() {
        return null;
    }

}
