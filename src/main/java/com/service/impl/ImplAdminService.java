package com.service.impl;

import com.cache.SessionCache;
import com.constants.Message;
import com.constants.ResponseResult;
import com.domain.AdminDetail;
import com.repository.AdminRepository;
import com.request.LoginAdminRequest;
import com.service.base.AdminService;
import com.utils.Token;
import com.utils.exception.ApplicationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplAdminService implements AdminService {

    private final AdminRepository adminRepository;
    private final SessionCache sessionCache;
    private final Token token;

    @Override
    public String loginAdmin(LoginAdminRequest loginAdminRequest) {
        AdminDetail adminDetail = adminRepository.findAdminDetail(loginAdminRequest.getUsername());
        String tokenResult = token.generationToken();

        if (adminDetail == null) {
            throw new ApplicationException(ResponseResult.USERNAME_UNREGISTERED, Message.USER_UNREGISTERED);
        }

        if (!loginAdminRequest.getPassword().equals(adminDetail.getPassword())) {
            throw new ApplicationException(ResponseResult.ERROR_USERNAME_OR_PASSWORD, Message.ERROR_USERNAME_OR_PASSWORD);
        }

        sessionCache.setSession(adminDetail.getId(), tokenResult);

        return tokenResult;
    }

    @Override
    public String logoutAdmin(String token) {
        sessionCache.removeSession(token);
        return Message.LOGOUT_SUCCESS;
    }

}
