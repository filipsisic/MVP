package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.main.MainInterfaces.ModelInterface;
import com.vasko.mvp.main.MainInterfaces.PresenterCallback;
import com.vasko.mvp.reftrofit.Rest;

public class MainModel extends BaseModel implements ModelInterface {

    private final PresenterCallback presenterCallback;

    public MainModel(PresenterCallback presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    @Override
    public BaseModel getModel() {
        return this;
    }

    @Override
    public void loadRepo(String username) {
        network(Rest.getClient().repositories(username),
                presenterCallback::onRepoSuccess,
                throwable -> presenterCallback.onRepoError());
    }

}
