package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubRepo;
import com.vasko.mvp.reftrofit.Rest;

import java.util.List;

import rx.Observable;

class MainModel extends BaseModel {

    private final PresenterInterface presenterCallback;

    public MainModel(PresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    public void loadRepo(String login) {
        Observable<List<GitHubRepo>> networkRepos = Rest.getClient().repositories(login);
        execute(networkRepos,
                presenterCallback::onRepoSuccess,
                throwable -> presenterCallback.onRepoError());
    }

}
