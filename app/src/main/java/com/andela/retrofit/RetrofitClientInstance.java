package com.andela.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {


    private static Retrofit retrofit;
    private static String BASE_URL = "https://newsapi.org/v2/";

    public static Retrofit getRetrofitClientInstance() {

        if(retrofit == null){

            retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                         .build();
        }
        return  retrofit;
    }
}
