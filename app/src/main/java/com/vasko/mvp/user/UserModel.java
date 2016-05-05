package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.reftrofit.Rest;

import rx.Observable;

class UserModel extends BaseModel {

    private final PresenterInterface presenterCallback;

    UserModel(PresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    void loadUser(String userName) {
        Observable<GitHubUser> networkUser = Rest.getClient().user(userName);
        execute(networkUser,
                presenterCallback::onUserSuccess,
                throwable -> presenterCallback.onUserError());
    }
}
