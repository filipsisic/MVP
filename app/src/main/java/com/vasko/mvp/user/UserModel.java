package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.reftrofit.Rest;

import rx.Observable;

class UserModel extends BaseModel {

    private final PresenterInterface presenterCallback;

    public UserModel(PresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    public void loadUser(String login) {
        Observable<GitHubUser> networkUser = Rest.getClient().user(login);
        execute(networkUser,
                presenterCallback::onUserSuccess,
                throwable -> presenterCallback.onUserError());
    }
}
