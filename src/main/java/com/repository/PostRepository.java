package com.repository;

import com.domain.PostDomain;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class PostRepository extends BaseRepository {

    public PostDomain insertPost(PostDomain postDomain) {
        return mongoOps.insert(postDomain);
    }

    public void deletePostById(String postId) {
        Query query = Query.query(Criteria.where(PostDomain.ID).is(postId));
        mongoOps.findAllAndRemove(query, PostDomain.class);
    }

}
