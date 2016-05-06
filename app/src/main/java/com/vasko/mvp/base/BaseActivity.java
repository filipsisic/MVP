package com.vasko.mvp.base;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract BasePresenter getBasePresenter();

    @Override
    protected void onStop() {
        super.onStop();
        getBasePresenter().onStop();
    }

}
