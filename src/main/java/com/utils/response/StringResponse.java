package com.utils.response;

import com.constants.ResponseResult;
import org.json.simple.JSONObject;

public class StringResponse extends ResponseData {

    public String message;

    public StringResponse() {
        super();
    }

    public StringResponse(int code) {
        super(code);
    }

    public StringResponse(int xcode, String xMessage) {
        super(xcode);
        this.message = xMessage;
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        if (this.message != null) {
            jsonObject.put(ResponseResult.MESSAGE, this.message);
        }
        return jsonObject;
    }

}
