package com.repository;

import com.domain.CategoryDetail;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryRepository extends BaseRepository {

    public CategoryDetail insertCategory(CategoryDetail categoryDetail) {
        return mongoOps.insert(categoryDetail);
    }

    public CategoryDetail updateCategory(String categoryId, CategoryDetail categoryDetail) {
        Query query = Query.query(Criteria.where(CategoryDetail.ID).is(categoryId));

        Update update = new Update();

        update.set(CategoryDetail.DESCRIPTION, categoryDetail.getDescription());
        update.set(CategoryDetail.UPDATE_TIME, categoryDetail.getUpdateTime());
        update.set(CategoryDetail.NAME, categoryDetail.getName());
        update.set(CategoryDetail.POST_NUMBER, categoryDetail.getPostNumber());

        mongoOps.upsert(query, update, CategoryDetail.class);

        CategoryDetail categoryDetailResult = mongoOps.findOne(query, CategoryDetail.class);
        return categoryDetailResult;
    }

    public List<CategoryDetail> getAllCategories() {
        return mongoOps.findAll(CategoryDetail.class);
    }

    public void deleteCategory(String categoryId) {
        Query query = Query.query(Criteria.where(CategoryDetail.ID).is(categoryId));
        mongoOps.findAllAndRemove(query, CategoryDetail.class);
    }

}
