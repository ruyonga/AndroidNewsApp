package com.andela;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.andela.adapters.CustomAdapter;
import com.andela.retrofit.RetrofitClientInstance;
import com.andela.retrofit.Retrofitinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerview;
    CustomAdapter customAdapter;
    ProgressDialog progressDoalog;
    List<Article> myarticle  = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        recyclerview = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager ll = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(ll);


        //Retroftit interface = Retrofti Instance
        Retrofitinterface services = RetrofitClientInstance.getRetrofitClientInstance().create(Retrofitinterface.class);
        Call<MyResponse> call = services.getArticles();
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                Log.d("response", response.body().getArticles().toString());
                progressDoalog.dismiss();

                assert response.body() != null;
                myarticle.addAll(Arrays.asList(response.body().getArticles()));
                customAdapter = new CustomAdapter(myarticle,  getApplicationContext());
                recyclerview.setAdapter(customAdapter);
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {

            }
        });

    }
}
