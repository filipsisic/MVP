package com.vasko.mvp.test;

import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.main.MainPresenter;

public class TestActivity extends BaseActivity {

    private MainPresenter mainPresenter;

    @Override
    public BasePresenter getPresenter() {
        return mainPresenter;
    }
}
