package com.vasko.mvp.repo;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.reftrofit.Rest;

class RepoModel extends BaseModel {

    private final PresenterInterface presenterCallback;

    public RepoModel(PresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    void loadUsers(String userName, String repoName) {
        network(Rest.getClient().contributors(userName, repoName),
                presenterCallback::onContributorsSuccess,
                throwable -> presenterCallback.onContributorsError());
    }
}
