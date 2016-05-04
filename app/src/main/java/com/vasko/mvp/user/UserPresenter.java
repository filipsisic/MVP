package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.user.UserInterfaces.ActivityInterface;
import com.vasko.mvp.user.UserInterfaces.ModelInterface;
import com.vasko.mvp.user.UserInterfaces.PresenterCallback;
import com.vasko.mvp.user.UserInterfaces.PresenterInterface;

public class UserPresenter extends BasePresenter implements PresenterInterface, PresenterCallback {

    private final ActivityInterface view;
    private final ModelInterface model;

    public UserPresenter(ActivityInterface view) {
        this.view = view;
        model = new UserModel(this);
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
