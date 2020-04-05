package com.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public abstract class BaseDomain {

    public static final String ID = "_id";
    public static final String CREATE_TIME = "create_time";
    public static final String UPDATE_TIME = "update_time";

    @Id
    private String id;

    @Field(CREATE_TIME)
    private Long createTime;

    @Field(UPDATE_TIME)
    private Long updateTime;
}
