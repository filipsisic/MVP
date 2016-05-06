package com.vasko.mvp.followers;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.followers.PresenterDeclaration.PresenterToModelInterface;
import com.vasko.mvp.reftrofit.Rest;

import java.util.List;

import rx.Observable;

/**
 * Created by Filip on 5.5.2016..
 */
class FollowersModel extends BaseModel implements ModelInterface {

    private PresenterToModelInterface presenter;

    public FollowersModel(PresenterToModelInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public BaseModel getModel() {
        return this;
    }

    public void loadFollowers(String login) {
        Observable<List<GitHubUser>> observable = Rest.getClient().followers(login);
        execute(observable,
                gitHubUsers -> presenter.onFollowersSuccess(gitHubUsers),
                throwable -> presenter.onFollowersError());
    }
}
