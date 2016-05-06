package com.vasko.mvp.followers;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.reftrofit.Rest;

import java.util.List;

import rx.Observable;

/**
 * Created by Filip on 5.5.2016..
 */
class FollowersModel extends BaseModel {

    private PresenterInterface presenter;

    public FollowersModel(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    public void loadFollowers(String login) {
        Observable<List<GitHubUser>> observable = Rest.getClient().followers(login);
        execute(observable,
                gitHubUsers -> presenter.onFollowersSuccess(gitHubUsers),
                throwable -> presenter.onFollowersError());
    }
}
