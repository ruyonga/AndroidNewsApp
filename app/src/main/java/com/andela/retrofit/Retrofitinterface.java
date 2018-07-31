package com.andela.retrofit;

import com.andela.MyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofitinterface {

    @GET("top-headlines?country=us&category=business&apiKey=ADD YOUR KEY")
    Call<MyResponse> getArticles();


}
