package com.vasko.mvp.base;

public abstract class BasePresenter implements Lifecycle {

    public abstract BaseModel getModel();

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {
        getModel().cancelAll();
    }

    @Override
    public void onDestroy() {

    }
}
