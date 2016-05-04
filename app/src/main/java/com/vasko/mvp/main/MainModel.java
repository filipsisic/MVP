package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.reftrofit.Rest;

public class MainModel extends BaseModel implements MainInterfaces.ModelInterface {

    private final MainInterfaces.PresenterCallback presenterCallback;

    public MainModel(MainInterfaces.PresenterCallback presenterCallback) {
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
