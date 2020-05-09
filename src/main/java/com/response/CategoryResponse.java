package com.response;

import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryResponse extends ResponseData {

    public String id;

    public String name;

    public String description;

    public Long postNumber;

    public Long createTime;

    public Long updateTime;

}
