package com.repository;

import com.domain.CategoryDetail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryRepository extends BaseRepository {

    public CategoryDetail insertCategory(CategoryDetail categoryDetail) {
        return mongoOps.insert(categoryDetail);
    }

    public List<CategoryDetail> getAllCategories() {
        return mongoOps.findAll(CategoryDetail.class);
    }

}
