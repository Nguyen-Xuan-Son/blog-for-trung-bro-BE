package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = CategoryDomain.COLLECTION)
public class CategoryDomain extends BaseDomain {
    public static final String COLLECTION = "category";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String POST_NUMBER = "post_number";

    @Field(NAME)
    private String name;

    @Field(DESCRIPTION)
    private String description;

    @Field(POST_NUMBER)
    private Long postNumber;
}
