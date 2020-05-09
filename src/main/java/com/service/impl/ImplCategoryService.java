package com.service.impl;

import com.domain.CategoryDomain;
import com.repository.CategoryRepository;
import com.request.CategoryRequest;
import com.request.CategoryUpdateRequest;
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
    public CategoryDomain createCategory(CategoryRequest categoryRequest) {
        CategoryDomain categoryDomain = ModelMapperCustomize.toObject(categoryRequest, CategoryDomain.class);
        return categoryRepository.insertCategory(categoryDomain);
    }

    @Override
    public CategoryDomain updateCategory(String categoryId, CategoryUpdateRequest categoryUpdateRequest) {
        CategoryDomain categoryDomain = ModelMapperCustomize.toObject(categoryUpdateRequest, CategoryDomain.class);
        return categoryRepository.updateCategory(categoryId, categoryDomain);
    }

    @Override
    public CategoryDomain getCategoryById(String categoryId) {
        return categoryRepository.getCategoryById(categoryId);
    }

    @Override
    public List<CategoryDomain> getCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public void deleteCategory(String categoryId) {
        categoryRepository.deleteCategory(categoryId);
    }
}
