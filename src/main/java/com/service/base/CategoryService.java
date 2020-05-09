package com.service.base;

import com.domain.CategoryDetail;
import com.request.CategoryRequest;
import com.request.CategoryUpdateRequest;

import java.util.List;

public interface CategoryService {

    CategoryDetail createCategory(CategoryRequest categoryRequest);

    CategoryDetail updateCategory(String categoryId, CategoryUpdateRequest categoryUpdateRequest);

    CategoryDetail getCategoryById(String categoryId);

    List<CategoryDetail> getCategories();

    void deleteCategory(String categoryId);

}
