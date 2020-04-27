package com.controller;

import com.constants.ResponseResult;
import com.service.base.AdminService;
import com.utils.response.ResponseData;
import com.utils.response.StringResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/remove-token")
public class LogoutController {

    private final AdminService adminService;

    @GetMapping()
    public ResponseData logout(@RequestHeader(value="Authorization") String token) {
        String result = adminService.logoutAdmin(token);
        StringResponse stringResponse = new StringResponse(ResponseResult.SUCCESS, result);
        return stringResponse;
    }

}
