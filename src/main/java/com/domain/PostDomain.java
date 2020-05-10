package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = PostDomain.COLLECTION)
public class PostDomain extends BaseDomain {

    public static final String COLLECTION = "post";
    public static final String TITLE = "title";
    public static final String NAME = "name";
    public static final String CONTENT = "content";
    public static final String AUTHOR = "author";
    public static final String VIEWED_NUMBER = "viewed_number";
    public static final String CATEGORY_ID = "category_id";
    public static final String COMMENT_NUMBER = "comment_number";
    public static final String TAGS = "tags";

    @Field(TITLE)
    private String title;

    @Field(NAME)
    private String name;

    @Field(TAGS)
    private List<String> tags;

    @Field(CONTENT)
    private String content;

    @Field(AUTHOR)
    private String author;

    @Field(VIEWED_NUMBER)
    private Long viewedNumber;

    @Field(COMMENT_NUMBER)
    private Long commentNumber;

    @Field(CATEGORY_ID)
    private String categoryId;
}
