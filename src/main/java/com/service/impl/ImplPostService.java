package com.service.impl;

import com.constants.Values;
import com.domain.PostDomain;
import com.repository.PostRepository;
import com.request.PostRequest;
import com.request.PostUpdateRequest;
import com.service.base.PostService;
import com.utils.ModelMapperCustomize;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<PostDomain> queryPost(String page, String size, String categoryId) {
        if (!categoryId.isEmpty() && categoryId.equals(Values.PARAM_QUERY_ALL)) {
            return postRepository.queryAllPost(page, size);
        }
        return postRepository.queryPost(page, size, categoryId);
    }

    @Override
    public void deletePostById(String postId) {
        postRepository.deletePostById(postId);
    }

    @Override
    public PostDomain updatePostById(String postId, PostUpdateRequest postUpdateRequest) {
        PostDomain postDomain = ModelMapperCustomize.toObject(postUpdateRequest, PostDomain.class);
        PostDomain postDomainResult =postRepository.updatePostById(postId, postDomain);
        return postDomainResult;
    }

}
