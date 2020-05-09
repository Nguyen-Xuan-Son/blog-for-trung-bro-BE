package com.repository;

import com.domain.AdminDomain;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class AdminRepository extends BaseRepository {

    public AdminDomain findAdminDetail(String username) {
        return mongoOps.findOne(new Query(Criteria.where(AdminDomain.USERNAME).is(username)), AdminDomain.class);
    }
}
