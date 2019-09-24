package com.alex.study.compents;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

@Route(path = "/service/bean")
public class AutoBean implements SerializationService {

    Gson mGson;
    private void check(){
        if (mGson==null) {
            mGson = new Gson();
        }
    }
    @Override
    public void init(Context context) {
        check();
    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
//        return JSON.parseObject(text, clazz);
        check();
        return mGson.fromJson(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
//        return JSON.toJSONString(instance);
        check();
        return mGson.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        check();
        return mGson.fromJson(input, clazz);
    }
}
