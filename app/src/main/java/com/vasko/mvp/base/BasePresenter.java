package com.vasko.mvp.base;

public abstract class BasePresenter {

    protected abstract BaseModel getBaseModel();

    void onStop() {
        getBaseModel().cancelAll();
    }

}
