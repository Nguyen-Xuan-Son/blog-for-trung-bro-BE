package com.utils.response;

import com.constants.ResponseResult;
import org.json.simple.JSONObject;

public abstract class ResponseData {

    public int code;

    public ResponseData() {
        this.code = ResponseResult.SUCCESS;
    }

    public ResponseData(int code) {
        this.code = code;
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(ResponseResult.CODE, code);
        return jsonObject;
    }
}
