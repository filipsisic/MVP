package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.reftrofit.Rest;

class UserModel extends BaseModel {

    private final UserPresenterInterface presenterCallback;

    public UserModel(UserPresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    public void loadUser(String username) {
        network(Rest.getClient().user(username),
                presenterCallback::onUserSuccess,
                throwable -> presenterCallback.onUserError());
    }
}
