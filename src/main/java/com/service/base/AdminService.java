package com.service.base;

import com.request.LoginAdminRequest;

public interface AdminService {

    String loginAdmin(LoginAdminRequest loginUserRequest);

    String logoutAdmin(String token);

}
