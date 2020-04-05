package com.repository;

import com.domain.AdminDetail;
import com.repository.base.AdminRepositoryCustomize;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<AdminDetail, String>, AdminRepositoryCustomize {
}
