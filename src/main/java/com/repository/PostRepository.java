package com.repository;

import com.domain.PostDomain;
import org.springframework.stereotype.Component;

@Component
public class PostRepository extends BaseRepository {

    public PostDomain insertPost(PostDomain postDomain) {
        return mongoOps.insert(postDomain);
    }

}
