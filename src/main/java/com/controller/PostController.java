package com.controller;

import com.constants.Message;
import com.constants.ResponseResult;
import com.domain.PostDomain;
import com.entity.PostEntity;
import com.request.PostRequest;
import com.request.PostUpdateRequest;
import com.response.PostsResponse;
import com.service.base.PostService;
import com.utils.response.EntityResponse;
import com.utils.response.ResponseData;
import com.utils.response.StringResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{postId}")
    public ResponseData updatePost(@PathVariable String postId, @RequestBody PostUpdateRequest postUpdateRequest) {
        PostDomain postDomain = postService.updatePostById(postId, postUpdateRequest);
        PostEntity postEntity = new PostEntity(postDomain);
        EntityResponse entityResponse = new EntityResponse(ResponseResult.SUCCESS, postEntity);
        return entityResponse;
    }

    @DeleteMapping("/{postId}")
    public ResponseData deletePost(@PathVariable String postId) {
        // todo
        postService.deletePostById(postId);
        StringResponse stringResponse = new StringResponse(ResponseResult.SUCCESS, Message.DELETE_POST_SUCCESS);
        return stringResponse;
    }

    @GetMapping
    public ResponseData queryPosts(
            @RequestParam String page,
            @RequestParam String size,
            @RequestParam String categoryId
    ) {
        List<PostDomain> postDomains = postService.queryPost(page, size, categoryId);
        PostsResponse postsResponse = new PostsResponse(postDomains);
        return postsResponse;
    }

    @GetMapping("/{postId}")
    public ResponseData getPostById(@PathVariable String postId) {
        PostDomain postDomain = postService.findPostById(postId);
        PostEntity postEntity = new PostEntity(postDomain);
        EntityResponse entityResponse = new EntityResponse(ResponseResult.SUCCESS, postEntity);
        return entityResponse;
    }

}
