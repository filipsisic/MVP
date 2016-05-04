package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.reftrofit.Rest;

class MainModel extends BaseModel {

    private final PresenterInterface presenterCallback;

    public MainModel(PresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    public void loadRepo(String userName) {
        network(Rest.getClient().repositories(userName),
                presenterCallback::onRepoSuccess,
                throwable -> presenterCallback.onRepoError());
    }

}
