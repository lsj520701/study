package com.alex.study.wanandroid;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {


    public static ApiManager mInstance;
    Retrofit mRetrofit;

    private  ApiManager(){

    }

    public static ApiManager getInstance(){

        if(mInstance==null){
            synchronized (ApiManager.class){
                if(mInstance==null){
                    mInstance=new ApiManager();

                }
            }
        }
        return mInstance;
    }



    public void initRetrofit(){

        if(mRetrofit!=null)return;
       mRetrofit =new Retrofit.Builder().baseUrl("https://www.wanandroid.com/").addConverterFactory(GsonConverterFactory.create()).
                build();
    }

    public StudyApi getStudyApi(){
        if(mRetrofit==null)initRetrofit();
        StudyApi api=mRetrofit.create(StudyApi.class);
        return api;

    }
}
