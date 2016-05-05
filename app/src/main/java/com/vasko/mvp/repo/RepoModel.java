package com.vasko.mvp.repo;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.reftrofit.Rest;

import java.util.List;

import rx.Observable;

class RepoModel extends BaseModel {

    private final PresenterInterface presenterCallback;

    RepoModel(PresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    void loadUsers(String userName, String repoName) {
        Observable<List<GitHubUser>> networkUsers = Rest.getClient().contributors(userName, repoName);
        execute(networkUsers,
                presenterCallback::onContributorsSuccess,
                throwable -> presenterCallback.onContributorsError());
    }
}
