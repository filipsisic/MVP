package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.reftrofit.Rest;

class UserModel extends BaseModel {

    private final PresenterInterface presenterCallback;

    UserModel(PresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    void loadUser(String userName) {
        network(Rest.getClient().user(userName),
                presenterCallback::onUserSuccess,
                throwable -> presenterCallback.onUserError());
    }
}
