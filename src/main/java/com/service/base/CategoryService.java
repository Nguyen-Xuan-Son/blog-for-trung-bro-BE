package com.service.base;

import com.domain.CategoryDetail;
import com.request.CategoryRequest;

public interface CategoryService {

    CategoryDetail createCategory(CategoryRequest categoryRequest);

}
