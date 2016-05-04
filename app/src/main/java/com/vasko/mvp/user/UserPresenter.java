package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

class UserPresenter extends BasePresenter implements UserPresenterInterface {

    private final UserActivityInterface view;
    private final UserModel model;

    public UserPresenter(UserActivityInterface view) {
        this.view = view;
        model = new UserModel(this);
    }

    @Override
    protected BaseModel getModel() {
        return model;
    }

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
