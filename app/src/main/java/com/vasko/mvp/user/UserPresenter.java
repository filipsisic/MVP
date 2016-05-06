package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.user.PresenterInterfaces.PresenterCallback;
import com.vasko.mvp.user.PresenterInterfaces.PresenterInterface;

class UserPresenter extends BasePresenter implements PresenterCallback, PresenterInterface {

    private final ActivityInterface view;
    private final ModelInterface model;

    public UserPresenter(ActivityInterface view) {
        this.view = view;
        model = new UserModel(this);
    }

    @Override
    public BasePresenter getBasePresenter() {
        return this;
    }

    @Override
    protected BaseModel getBaseModel() {
        return model.getBaseModel();
    }

    @Override
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
