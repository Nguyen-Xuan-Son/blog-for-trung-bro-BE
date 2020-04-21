package com.repository;

import com.domain.AdminDetail;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class AdminRepository extends BaseRepository {

    public AdminDetail findAdminDetail(String username) {
        return mongoOps.findOne(new Query(Criteria.where(AdminDetail.USERNAME).is(username)), AdminDetail.class);
    }
}
