package com.controller;

import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    @PostMapping
    public ResponseData createCategory() {
        // todo
        return null;
    }

    @PutMapping
    public ResponseData updateCategory() {
        // todo
        return null;
    }

    @DeleteMapping
    public ResponseData deleteCategory() {
        // todo
        return null;
    }

    @GetMapping
    public ResponseData getCategories() {
        // todo
        return null;
    }

}
