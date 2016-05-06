package com.vasko.mvp.followers;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.followers.PresenterInterfaces.PresenterCallback;
import com.vasko.mvp.reftrofit.Rest;

import java.util.List;

import rx.Observable;

class FollowersModel extends BaseModel implements ModelInterface {

    private final PresenterCallback presenter;

    public FollowersModel(PresenterCallback presenter) {
        this.presenter = presenter;
    }

    @Override
    public BaseModel getBaseModel() {
        return this;
    }

    @Override
    public void loadFollowers(String login) {
        Observable<List<GitHubUser>> observable = Rest.getClient().followers(login);
        execute(observable,
                presenter::onFollowersSuccess,
                throwable -> presenter.onFollowersError());
    }
}
