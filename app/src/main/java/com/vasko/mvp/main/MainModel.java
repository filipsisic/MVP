package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubRepo;
import com.vasko.mvp.database.Database;
import com.vasko.mvp.reftrofit.Rest;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

class MainModel extends BaseModel {

    private final PresenterInterface presenterCallback;

    public MainModel(PresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    public void loadRepo(String login) {
        Observable<List<GitHubRepo>> networkRepos = Rest.getClient().repositories(login);
        Observable<List<GitHubRepo>> databaseResponse = Database.async().getRepos();
        Observable<List<GitHubRepo>> zip = Observable.zip(networkRepos, databaseResponse, (gitHubRepos, gitHubRepos2) -> {
            List<GitHubRepo> temp = new ArrayList<>();
            temp.addAll(gitHubRepos);
            temp.addAll(gitHubRepos2);
            return temp;
        });
        execute(zip,
                presenterCallback::onRepoSuccess,
                throwable -> presenterCallback.onRepoError());
    }

}
