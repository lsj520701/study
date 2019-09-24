package com.alex.study.wanandroid;

import com.alex.study.wanandroid.beans.GetArticlesBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StudyApi {

    @GET("/article/list/"+"{indexId}"+"/json")
    Call<GetArticlesBean> getArticles(@Path("indexId")int indexId);
}
