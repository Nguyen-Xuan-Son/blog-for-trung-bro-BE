package com.entity;

import com.constants.ResponseResult;
import com.domain.CategoryDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
@AllArgsConstructor
public class CategoryEntity implements BaseEntity {

    private CategoryDomain categoryDetail;

    @Override
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();

        if (categoryDetail != null) {
            json.put(ResponseResult.DATA, categoryDetail);
        }

        return json;
    }

}
