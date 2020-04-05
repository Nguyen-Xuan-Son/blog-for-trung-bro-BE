package com.entity.admin;

import com.constants.ResponseResult;
import com.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.simple.JSONObject;

@Data
@AllArgsConstructor
public class AdminEntity implements BaseEntity {

    private String token;

    @Override
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();

        if (token != null) {
            json.put(ResponseResult.TOKEN, token);
        }

        return json;
    }

}
