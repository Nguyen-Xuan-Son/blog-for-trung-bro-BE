package com.controller;

import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    @PostMapping
    public ResponseData createPost() {
        // todo
        return null;
    }

    @PutMapping
    public ResponseData updatePost() {
        // todo
        return null;
    }

    @DeleteMapping
    public ResponseData deletePost() {
        // todo
        return null;
    }

    @GetMapping
    public ResponseData queryPosts() {
        // todo
        return null;
    }

    @GetMapping
    public ResponseData getPostById() {
        // todo
        return null;
    }

    @GetMapping
    public ResponseData searchPostByTagName() {
        // todo
        return null;
    }

}
