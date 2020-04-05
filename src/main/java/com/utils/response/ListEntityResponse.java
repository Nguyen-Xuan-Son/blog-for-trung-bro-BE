package com.utils.response;

import com.constants.ResponseResult;
import com.entity.BaseEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class ListEntityResponse<T> extends ResponseData {

    public List<T> data;

    public ListEntityResponse() {
        super();
    }

    public ListEntityResponse(int code) {
        super(code);
    }

    public ListEntityResponse(int xcode, List<T> xData) {
        super(xcode);
        this.data = xData;
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        if (this.data != null) {
            JSONArray jsonArray = new JSONArray();
            for (T el: this.data) {
                jsonArray.add(((BaseEntity)el).toJsonObject());
            }
            jsonObject.put(ResponseResult.DATA, jsonArray);
        }
        return jsonObject;
    }
}
