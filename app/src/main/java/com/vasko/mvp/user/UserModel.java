package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.reftrofit.Rest;
import com.vasko.mvp.user.UserInterfaces.ModelInterface;
import com.vasko.mvp.user.UserInterfaces.PresenterCallback;

public class UserModel extends BaseModel implements ModelInterface {

    private final PresenterCallback presenterCallback;

    public UserModel(PresenterCallback presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    @Override
    public BaseModel getModel() {
        return this;
    }

    @Override
    public void loadUser(String username) {
        network(Rest.getClient().user(username),
                presenterCallback::onUserSuccess,
                throwable -> presenterCallback.onUserError());
    }
}
