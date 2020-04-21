package com.repository;

import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class BaseRepository {
    MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "blogsTrungBro");
}
