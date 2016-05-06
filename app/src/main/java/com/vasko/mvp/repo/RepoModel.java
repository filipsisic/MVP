package com.vasko.mvp.repo;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.reftrofit.Rest;
import com.vasko.mvp.repo.PresenterInterfaces.PresenterCallback;

import java.util.List;

import rx.Observable;

class RepoModel extends BaseModel implements ModelInterface {

    private final PresenterCallback presenterCallback;

    public RepoModel(PresenterCallback presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    @Override
    public BaseModel getBaseModel() {
        return this;
    }

    @Override
    public void loadUsers(String login, String repoName) {
        Observable<List<GitHubUser>> networkUsers = Rest.getClient().contributors(login, repoName);
        execute(networkUsers,
                presenterCallback::onContributorsSuccess,
                throwable -> presenterCallback.onContributorsError());
    }
}
