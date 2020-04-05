package com.repository.base;

import com.domain.AdminDetail;

public interface AdminRepositoryCustomize {

    AdminDetail findAdminByUsernameOrEmail(String usernameOrEmail);

}
