package com.repository.impl;

import com.domain.AdminDetail;
import com.repository.base.AdminRepositoryCustomize;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AdminRepositoryImpl implements AdminRepositoryCustomize {

    private final MongoOperations mongoOperations;

    @Override
    public AdminDetail findAdminByUsernameOrEmail(String usernameOrEmail) {
        Criteria criteria = new Criteria();
        criteria.orOperator(
                Criteria.where(AdminDetail.USERNAME).is(usernameOrEmail),
                Criteria.where(AdminDetail.EMAIL).is(usernameOrEmail)
        );

        Query query = new Query(criteria);

        AdminDetail adminDetail = mongoOperations.findOne(query, AdminDetail.class);
        return adminDetail;
    }

}
