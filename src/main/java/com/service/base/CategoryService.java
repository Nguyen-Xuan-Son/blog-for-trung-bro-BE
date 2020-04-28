package com.service.base;

import com.domain.CategoryDetail;
import com.request.CategoryRequest;

import java.util.List;

public interface CategoryService {

    CategoryDetail createCategory(CategoryRequest categoryRequest);

    List<CategoryDetail> getCategories();

}
