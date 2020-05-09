package com.entity;

import com.constants.ResponseResult;
import com.domain.CategoryDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
@AllArgsConstructor
public class CategoryEntity implements BaseEntity {

    private CategoryDomain categoryDomain;

    @Override
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();

        if (categoryDomain != null) {
            json.put(ResponseResult.DATA, categoryDomain);
        }

        return json;
    }

}
