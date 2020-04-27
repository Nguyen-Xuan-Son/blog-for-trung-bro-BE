package com.controller;

import com.constants.ResponseResult;
import com.domain.CategoryDetail;
import com.entity.admin.CategoryEntity;
import com.request.CategoryRequest;
import com.service.base.CategoryService;
import com.utils.response.EntityResponse;
import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
            @RequestBody CategoryRequest categoryRequest
    ) {
        // todo
        return null;
    }

    @DeleteMapping("/{categoryId}")
    public ResponseData deleteCategory(@PathVariable String categoryId) {
        // todo
        return null;
    }

    @GetMapping("/{categoryId}")
    public ResponseData getCategories(@PathVariable String categoryId) {
        // todo
        return null;
    }

}
