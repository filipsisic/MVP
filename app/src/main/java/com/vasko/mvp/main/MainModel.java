package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.reftrofit.Rest;

class MainModel extends BaseModel {

    private final MainPresenterInterface presenterCallback;

    public MainModel(MainPresenterInterface presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    public void loadRepo(String username) {
        network(Rest.getClient().repositories(username),
                presenterCallback::onRepoSuccess,
                throwable -> presenterCallback.onRepoError());
    }

}
