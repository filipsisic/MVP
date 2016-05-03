package com.vasko.mvp.reftrofit;

import com.vasko.mvp.data.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Network {

    @GET("users/{username}/repos")
    Call<List<Repo>> repositories(@Path("username") String username);

}
