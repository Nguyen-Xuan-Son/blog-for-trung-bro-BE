package com.service.base;

import com.domain.PostDomain;
import com.request.PostRequest;

import java.util.List;

public interface PostService {

    PostDomain createPost(PostRequest postRequest);

    List<PostDomain> queryPost(String page, String size, String categoryId);

    void deletePostById(String postId);

    PostDomain updatePostById();

}

