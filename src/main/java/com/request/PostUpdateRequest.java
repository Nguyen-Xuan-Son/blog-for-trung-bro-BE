package com.request;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PostUpdateRequest {

    private String title;

    private String content;

    private ArrayList<String> tags;

    private String categoryId;

}
