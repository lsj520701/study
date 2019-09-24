package com.alex.study.wanandroid;

import android.app.IntentService;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alex.study.R;
import com.alex.study.wanandroid.beans.GetArticlesBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.HandlerPoster;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dalvik.system.DexClassLoader;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okio.BufferedSource;
import okio.Sink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WanAct extends AppCompatActivity {

    private static final String TAG = "wan";
    @BindView(R.id.tvRegister)
    TextView mTvRegister;
    @BindView(R.id.tvLogin)
    TextView mTvLogin;
    @BindView(R.id.tvGet)
    TextView mTvGet;
    @BindView(R.id.tvShow)
    TextView mTvShow;
    @BindView(R.id.tvGetArticales)
    TextView tvGetArticales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wan);
        ButterKnife.bind(this);
        getClassLoader().toString();


    }

    @OnClick({R.id.tvRegister, R.id.tvLogin, R.id.tvGet,R.id.tvGetArticales})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvRegister:
                register();
                break;
            case R.id.tvLogin:
                break;
            case R.id.tvGet:

                break;
            case R.id.tvGetArticales:
                getArticle();
                break;
        }

    }
    private void getArticle(){




   Call<GetArticlesBean> call= ApiManager.getInstance().getStudyApi().getArticles(0);
   call.enqueue(new Callback<GetArticlesBean>() {
       @Override
       public void onResponse(Call<GetArticlesBean> call, Response<GetArticlesBean> response) {
           if(response.isSuccessful()){
               mTvShow.setText(response.body().getData().getDatas().toString());
           }
       }

       @Override
       public void onFailure(Call<GetArticlesBean> call, Throwable t) {

       }
   });

    }
    String url="https://www.wanandroid.com/user/register";
    boolean isRegister=false;

    private void register(){

/*
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        RequestBody body=new FormBody.Builder().add("username","alex6666")
                .add("password","12345678").add("repassword","12345678").build();

        Request request = new Request.Builder()
                .url(url).post(body)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG,"response : "+response.body().string());
                if(response.isSuccessful()){
                    Log.i(TAG,"在线程: "+Thread.currentThread().getName()+" 注册成功");
                }

            }
        });*/



    }
    private void getInfo(){

    }
}
