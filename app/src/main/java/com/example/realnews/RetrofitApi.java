package com.example.realnews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitApi {
    @GET
    Call<List<Articles>> getAllNews(@Url String url);
}
