package com.controller;

import com.constants.ResponseResult;
import com.domain.PostDomain;
import com.entity.PostEntity;
import com.request.PostRequest;
import com.service.base.PostService;
import com.utils.response.EntityResponse;
import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseData createPost(@RequestBody PostRequest postRequest) {
        PostDomain postDomain = postService.createPost(postRequest);
        PostEntity postEntity = new PostEntity(postDomain);
        EntityResponse entityResponse = new EntityResponse(ResponseResult.SUCCESS, postEntity);
        return entityResponse;
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
