package com.vasko.mvp.reftrofit;

import com.vasko.mvp.data.GitHubRepo;
import com.vasko.mvp.data.GitHubUser;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface Network {

    @GET("users/{username}")
    Observable<GitHubUser> user(@Path("username") String username);

    @GET("users/{username}/repos")
    Observable<List<GitHubRepo>> repositories(@Path("username") String username);

}
