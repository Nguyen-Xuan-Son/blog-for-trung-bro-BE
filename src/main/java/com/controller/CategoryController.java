package com.controller;

import com.request.CategoryRequest;
import com.service.base.CategoryService;
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
        System.out.println("categoryRequest: " + categoryRequest.toString());
        categoryService.createCategory(categoryRequest);
        return null;
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
