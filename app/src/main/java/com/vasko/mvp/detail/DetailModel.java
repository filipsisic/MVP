package com.vasko.mvp.detail;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.reftrofit.Rest;

public class DetailModel extends BaseModel implements DetailInterfaces.ModelInterface {

    private final DetailInterfaces.PresenterCallback presenterCallback;

    public DetailModel(DetailInterfaces.PresenterCallback presenterCallback) {
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
