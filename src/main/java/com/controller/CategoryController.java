package com.controller;

import com.constants.Message;
import com.constants.ResponseResult;
import com.domain.CategoryDetail;
import com.entity.CategoryEntity;
import com.request.CategoryRequest;
import com.request.CategoryUpdateRequest;
import com.response.CategoriesResponse;
import com.service.base.CategoryService;
import com.utils.response.EntityResponse;
import com.utils.response.ResponseData;
import com.utils.response.StringResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping
    public ResponseData createCategory(@RequestBody CategoryRequest categoryRequest) {
        CategoryDetail categoryDetail = categoryService.createCategory(categoryRequest);
        CategoryEntity categoryEntity = new CategoryEntity(categoryDetail);
        EntityResponse entityResponse = new EntityResponse(ResponseResult.SUCCESS, categoryEntity);
        return entityResponse;
    }

    @PutMapping("/{categoryId}")
    public ResponseData updateCategory(
            @PathVariable String categoryId,
            @RequestBody CategoryUpdateRequest categoryUpdateRequest
    ) {
        CategoryDetail categoryDetail = categoryService.updateCategory(categoryId, categoryUpdateRequest);
        CategoryEntity categoryEntity = new CategoryEntity(categoryDetail);
        EntityResponse entityResponse = new EntityResponse(ResponseResult.SUCCESS, categoryEntity);
        return entityResponse;
    }

    @DeleteMapping("/{categoryId}")
    public ResponseData deleteCategory(@PathVariable String categoryId) {
        categoryService.deleteCategory(categoryId);
        StringResponse entityResponse = new StringResponse(ResponseResult.SUCCESS, Message.DELETE_CATEGORY_SUCCESS);
        return entityResponse;
    }

    @GetMapping("/{categoryId}")
    public ResponseData getCategoryById(@PathVariable String categoryId) {
        // todo
        return null;
    }

    @GetMapping("/all")
    public ResponseData getCategories() {
        List<CategoryDetail> categoryDetails =  categoryService.getCategories();
        CategoriesResponse categoriesResponse = new CategoriesResponse(categoryDetails);
        return categoriesResponse;
    }

}
