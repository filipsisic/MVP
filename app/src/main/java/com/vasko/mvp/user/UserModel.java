package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.reftrofit.Rest;
import com.vasko.mvp.user.PresenterInterfaces.PresenterCallback;

import rx.Observable;

class UserModel extends BaseModel implements ModelInterface {

    private final PresenterCallback presenterCallback;

    public UserModel(PresenterCallback presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    @Override
    public BaseModel getBaseModel() {
        return this;
    }

    @Override
    public void loadUser(String login) {
        Observable<GitHubUser> networkUser = Rest.getClient().user(login);
        execute(networkUser,
                presenterCallback::onUserSuccess,
                throwable -> presenterCallback.onUserError());
    }
}
