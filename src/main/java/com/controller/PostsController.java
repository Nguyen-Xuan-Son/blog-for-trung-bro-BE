package com.controller;

import com.request.PostRequest;
import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/post")
public class PostsController {

    @PostMapping
    public ResponseData createPost(@RequestBody PostRequest postRequest) {
        System.out.println("postRequest: " + postRequest.toString());
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

    @GetMapping("/{id}")
    public ResponseData getPostsById() {
        // todo
        return null;
    }

}
