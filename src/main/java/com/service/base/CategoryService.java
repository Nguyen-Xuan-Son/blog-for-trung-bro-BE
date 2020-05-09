package com.service.base;

import com.domain.CategoryDomain;
import com.request.CategoryRequest;
import com.request.CategoryUpdateRequest;

import java.util.List;

public interface CategoryService {

    CategoryDomain createCategory(CategoryRequest categoryRequest);

    CategoryDomain updateCategory(String categoryId, CategoryUpdateRequest categoryUpdateRequest);

    CategoryDomain getCategoryById(String categoryId);

    List<CategoryDomain> getCategories();

    void deleteCategory(String categoryId);

}
