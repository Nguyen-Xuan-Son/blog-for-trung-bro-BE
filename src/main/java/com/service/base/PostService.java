package com.service.base;

import com.domain.PostDomain;
import com.request.PostRequest;

public interface PostService {

    PostDomain createPost(PostRequest postRequest);

    PostDomain updatePostById();

}
