package com.service.base;

import com.domain.PostDomain;
import com.request.PostRequest;
import com.request.PostUpdateRequest;

import java.util.List;

public interface PostService {

    PostDomain createPost(PostRequest postRequest);

    List<PostDomain> queryPost(String page, String size, String categoryId);

    void deletePostById(String postId);

    PostDomain updatePostById(String postId, PostUpdateRequest postUpdateRequest);

    PostDomain findPostById(String postId);

}
