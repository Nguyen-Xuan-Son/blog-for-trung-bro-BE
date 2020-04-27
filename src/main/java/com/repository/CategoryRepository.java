package com.repository;

import com.domain.CategoryDetail;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepository extends BaseRepository {

    public CategoryDetail insertCategory(CategoryDetail categoryDetail) {
        return mongoOps.insert(categoryDetail);
    }

}
