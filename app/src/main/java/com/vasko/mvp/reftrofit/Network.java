package com.vasko.mvp.reftrofit;

import com.vasko.mvp.data.GitHubRepo;
import com.vasko.mvp.data.GitHubUser;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface Network {

    @GET("users/{login}")
    Observable<GitHubUser> user(@Path("login") String login);

    @GET("users/{login}/repos")
    Observable<List<GitHubRepo>> repositories(@Path("login") String login);

    @GET("repos/{login}/{repo}/contributors")
    Observable<List<GitHubUser>> contributors(@Path("login") String login, @Path("repo") String repo);

}
