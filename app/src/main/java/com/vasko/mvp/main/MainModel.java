package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubRepo;
import com.vasko.mvp.reftrofit.Rest;

import java.util.List;

import rx.Observable;

class MainModel extends BaseModel {

    private final PresenterInterface presenterCallback;

    MainModel(PresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    void loadRepo(String userName) {
        Observable<List<GitHubRepo>> networkRepos = Rest.getClient().repositories(userName);
        execute(networkRepos,
                presenterCallback::onRepoSuccess,
                throwable -> presenterCallback.onRepoError());
    }

}
