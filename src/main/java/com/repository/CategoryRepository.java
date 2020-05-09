package com.repository;

import com.domain.CategoryDomain;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryRepository extends BaseRepository {

    public CategoryDomain insertCategory(CategoryDomain categoryDomain) {
        return mongoOps.insert(categoryDomain);
    }

    public CategoryDomain updateCategory(String categoryId, CategoryDomain categoryDomain) {
        Query query = Query.query(Criteria.where(CategoryDomain.ID).is(categoryId));

        Update update = new Update();

        update.set(CategoryDomain.DESCRIPTION, categoryDomain.getDescription());
        update.set(CategoryDomain.UPDATE_TIME, categoryDomain.getUpdateTime());
        update.set(CategoryDomain.NAME, categoryDomain.getName());
        update.set(CategoryDomain.POST_NUMBER, categoryDomain.getPostNumber());

        mongoOps.upsert(query, update, CategoryDomain.class);

        CategoryDomain categoryDomainResult = mongoOps.findOne(query, CategoryDomain.class);
        return categoryDomainResult;
    }

    public List<CategoryDomain> getAllCategories() {
        return mongoOps.findAll(CategoryDomain.class);
    }

    public void deleteCategory(String categoryId) {
        Query query = Query.query(Criteria.where(CategoryDomain.ID).is(categoryId));
        mongoOps.findAllAndRemove(query, CategoryDomain.class);
    }

    public CategoryDomain getCategoryById (String categoryId) {
        Query query = Query.query(Criteria.where(CategoryDomain.ID).is(categoryId));
        return mongoOps.findOne(query, CategoryDomain.class);
    }

}
