package com.vasko.mvp.detail;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

public class DetailPresenter extends BasePresenter implements DetailInterfaces.AtoP, DetailInterfaces.MtoP {

    private final DetailInterfaces.PtoA view;
    private final DetailModel model;

    public DetailPresenter(DetailInterfaces.PtoA view) {
        this.view = view;
        model = new DetailModel(this);
    }

    @Override
    protected BaseModel getModel() {
        return model;
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
