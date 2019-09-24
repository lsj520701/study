package com.alex.study.compents;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 1)
public class UIInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        String name=Thread.currentThread().getName();
        Log.i(Constants.TAG,"线程名字是:   "+name);
        if(postcard.getPath().equals(Constants.ONE_PATH)){

            Log.e(Constants.TAG,"对OneAct进行了 拦截");
        }
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {

        Log.e(Constants.TAG,"拦截器进行 init");
    }
}
