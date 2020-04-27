package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document(collection = CategoryDetail.COLLECTION)
public class CategoryDetail extends BaseDomain {
    public static final String COLLECTION = "category";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String POST_NUMBER = "post_number";

    @Field(NAME)
    public String name;

    @Field(DESCRIPTION)
    public String description;

    @Field(POST_NUMBER)
    private Long post_number;
}
