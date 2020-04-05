package com.controller;

import com.constants.ResponseResult;
import com.entity.admin.AdminEntity;
import com.request.LoginAdminRequest;
import com.service.base.AdminService;
import com.utils.response.EntityResponse;
import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    private final AdminService adminService;

    @PostMapping
    private ResponseData login(@RequestBody LoginAdminRequest loginAdminRequest) {
        String token = adminService.loginAdmin(loginAdminRequest);
        AdminEntity adminEntity = new AdminEntity(token);
        EntityResponse entityResponse = new EntityResponse(ResponseResult.SUCCESS, adminEntity);
        return entityResponse;
    }

}
