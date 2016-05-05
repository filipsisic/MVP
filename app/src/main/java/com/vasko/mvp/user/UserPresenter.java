package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

class UserPresenter extends BasePresenter implements PresenterInterface {

    private final ActivityInterface view;
    private final UserModel model;

    public UserPresenter(ActivityInterface view) {
        this.view = view;
        model = new UserModel(this);
    }

    @Override
    protected BaseModel getModel() {
        return model;
    }

    public void loadUser(String login) {
        model.loadUser(login);
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
