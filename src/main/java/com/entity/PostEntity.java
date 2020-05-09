package com.entity;

import com.constants.ResponseResult;
import com.domain.PostDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
@AllArgsConstructor
public class PostEntity implements BaseEntity {

    private PostDomain postDetail;

    @Override
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();

        if (postDetail != null) {
            json.put(ResponseResult.DATA, postDetail);
        }

        return json;
    }

}
