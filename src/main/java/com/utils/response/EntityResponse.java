package com.utils.response;

import com.constants.ResponseResult;
import com.entity.BaseEntity;
import org.json.simple.JSONObject;

public class EntityResponse extends ResponseData {

    public BaseEntity data;

    public EntityResponse() {
        super();
        this.data = null;
    }

    public EntityResponse(int code) {
        super(code);
        this.data = null;
    }

    public EntityResponse(int xcode, BaseEntity data) {
        super(xcode);
        this.data = data;
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        if (this.data != null) {
            jsonObject.put(ResponseResult.DATA, this.data.toJsonObject());
        }
        return jsonObject;
    }
}
