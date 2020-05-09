package com.controller;

import com.constants.Message;
import com.constants.ResponseResult;
import com.domain.PostDomain;
import com.entity.PostEntity;
import com.request.PostRequest;
import com.service.base.PostService;
import com.utils.response.EntityResponse;
import com.utils.response.ResponseData;
import com.utils.response.StringResponse;
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

    @DeleteMapping("/{postId}")
    public ResponseData deletePost(@PathVariable String postId) {
        // todo
        postService.deletePostById(postId);
        StringResponse stringResponse = new StringResponse(ResponseResult.SUCCESS, Message.DELETE_POST_SUCCESS);
        return stringResponse;
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
