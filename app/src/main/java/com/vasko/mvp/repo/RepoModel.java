package com.vasko.mvp.repo;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.reftrofit.Rest;

import java.util.List;

import rx.Observable;

class RepoModel extends BaseModel {

    private final PresenterInterface presenterCallback;

    public RepoModel(PresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    public void loadUsers(String login, String repoName) {
        Observable<List<GitHubUser>> networkUsers = Rest.getClient().contributors(login, repoName);
        execute(networkUsers,
                presenterCallback::onContributorsSuccess,
                throwable -> presenterCallback.onContributorsError());
    }
}
