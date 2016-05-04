package com.vasko.mvp.base;

public abstract class BasePresenter {

    protected abstract BaseModel getModel();

    void onStop() {
        getModel().cancelAll();
    }

}
