package com.service.impl;

import com.domain.PostDomain;
import com.repository.PostRepository;
import com.request.PostRequest;
import com.service.base.PostService;
import com.utils.ModelMapperCustomize;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplPostService implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostDomain createPost(PostRequest postRequest) {
        PostDomain postDomain = ModelMapperCustomize.toObject(postRequest, PostDomain.class);
        return postRepository.insertPost(postDomain);
    }

    @Override
    public void deletePostById(String postId) {
        postRepository.deletePostById(postId);
    }

    @Override
    public PostDomain updatePostById() {
        return null;
    }
}
