package com.repository;

import com.domain.PostDomain;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostRepository extends BaseRepository {

    public PostDomain insertPost(PostDomain postDomain) {
        return mongoOps.insert(postDomain);
    }

    public void deletePostById(String postId) {
        Query query = Query.query(Criteria.where(PostDomain.ID).is(postId));
        mongoOps.findAllAndRemove(query, PostDomain.class);
    }

    public PostDomain updatePostById(String postId, PostDomain postDomain) {
        Query query = Query.query(Criteria.where(PostDomain.ID).is(postId));

        Update update = new Update();

        update.set(PostDomain.TITLE, postDomain.getTitle());
        update.set(PostDomain.CONTENT, postDomain.getContent());
        update.set(PostDomain.CATEGORY_ID, postDomain.getCategoryId());
        update.set(PostDomain.TAGS, postDomain.getTags());

        mongoOps.upsert(query, update, PostDomain.class);

        PostDomain postDomainResult = mongoOps.findOne(query, PostDomain.class);
        return postDomainResult;
    }

    public List<PostDomain> queryPost(String page, String size, String categoryId) {
        final Pageable pageableRequest = PageRequest.of(Integer.parseInt(page) , Integer.parseInt(size));
        Query query = Query.query(Criteria.where(PostDomain.CATEGORY_ID).is(categoryId));
        query.with(pageableRequest);

        List<PostDomain> result = mongoOps.find(query, PostDomain.class);;
        return result;
    }

    public List<PostDomain>  queryAllPost(String page, String size) {
        final Pageable pageableRequest = PageRequest.of(Integer.parseInt(page) , Integer.parseInt(size));
        Query query = new Query();
        query.with(pageableRequest);

        List<PostDomain> result = mongoOps.find(query, PostDomain.class);;
        return result;
    }

    public PostDomain findPostById(String postId) {
        Query query = Query.query(Criteria.where(PostDomain.ID).is(postId));
        PostDomain postDomainResult = mongoOps.findOne(query, PostDomain.class);
        return postDomainResult;
    }
}
