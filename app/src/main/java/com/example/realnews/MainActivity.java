package com.example.realnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    List<Articles> articlesArrayList;
    NewsRvAdapter newsRvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.rc2);
        progressBar = (ProgressBar)findViewById(R.id.pg);
        articlesArrayList = new ArrayList<>();
        news();
    }
    private void news(){
        progressBar.setVisibility(View.VISIBLE);
        articlesArrayList.clear();
        String url = "http://universities.hipolabs.com/search?country=India";
        String BASE_URL="http://universities.hipolabs.com/";
        Retrofit retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<List<Articles>> call;
        call = retrofitApi.getAllNews(url);
        call.enqueue(new Callback<List<Articles>>() {
            @Override
            public void onResponse(Call<List<Articles>> call, Response<List<Articles>> response) {
               articlesArrayList = response.body();
               progressBar.setVisibility(View.GONE);
                newsRvAdapter = new NewsRvAdapter(articlesArrayList , getApplicationContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(newsRvAdapter);
            }
            @Override
            public void onFailure(Call<List<Articles>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}