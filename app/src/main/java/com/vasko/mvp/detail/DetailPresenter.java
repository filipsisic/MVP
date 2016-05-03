package com.vasko.mvp.detail;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

public class DetailPresenter extends BasePresenter implements DetailInterfaces.PresenterInterface, DetailInterfaces.PresenterCallback {

    private final DetailInterfaces.ActivityInterface view;
    private final DetailInterfaces.ModelInterface model;

    public DetailPresenter(DetailInterfaces.ActivityInterface view) {
        this.view = view;
        model = new DetailModel(this);
    }

    @Override
    protected BaseModel getModel() {
        return model.getModel();
    }

    @Override
    public BasePresenter getPresenter() {
        return this;
    }

    @Override
    public void loadUser(String username) {
        model.loadUser(username);
    }

    @Override
    public void onUserSuccess(GitHubUser user) {
        view.showUser(user);
    }

    @Override
    public void onUserError() {
        view.showError();
    }
}
