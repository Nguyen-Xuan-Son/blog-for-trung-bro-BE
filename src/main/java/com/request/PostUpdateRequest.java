package com.request;

import lombok.Data;

@Data
public class PostUpdateRequest {

    private String title;

    private String content;

    private String tags;

    private String categoryId;

}
