package com.vasko.mvp.base;

public abstract class BasePresenter {

    protected abstract BaseModel getModel();

    protected void onCreate() {

    }

    protected void onStart() {

    }

    protected void onResume() {

    }

    protected void onPause() {

    }

    protected void onStop() {
        getModel().cancelAll();
    }

    protected void onDestroy() {

    }
}
