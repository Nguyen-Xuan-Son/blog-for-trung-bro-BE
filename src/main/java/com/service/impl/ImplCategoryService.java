package com.service.impl;

import com.domain.CategoryDetail;
import com.repository.CategoryRepository;
import com.request.CategoryRequest;
import com.service.base.CategoryService;
import com.utils.ModelMapperCustomize;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplCategoryService implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDetail createCategory(CategoryRequest categoryRequest) {
        CategoryDetail categoryDetail = ModelMapperCustomize.toObject(categoryRequest, CategoryDetail.class);
        return categoryRepository.insertCategory(categoryDetail);
    }

    @Override
    public List<CategoryDetail> getCategories() {
        return categoryRepository.getAllCategories();
    }
}
