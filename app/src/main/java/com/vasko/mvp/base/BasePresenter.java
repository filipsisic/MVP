package com.vasko.mvp.base;

public abstract class BasePresenter {

    protected abstract BaseModel getModel();

    void onStart() {

    }

    void onResume() {

    }

    void onPause() {

    }

    void onStop() {
        getModel().cancelAll();
    }

    void onDestroy() {

    }
}
