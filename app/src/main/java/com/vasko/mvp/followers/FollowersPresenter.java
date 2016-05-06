package com.vasko.mvp.followers;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.followers.PresenterInterfaces.PresenterCallback;
import com.vasko.mvp.followers.PresenterInterfaces.PresenterInterface;

import java.util.List;

class FollowersPresenter extends BasePresenter implements PresenterCallback, PresenterInterface {

    private final ActivityInterface activity;
    private final ModelInterface followersModel;

    public FollowersPresenter(ActivityInterface activity) {
        this.activity = activity;
        followersModel = new FollowersModel(this);
    }

    @Override
    public BasePresenter getPresenter() {
        return this;
    }

    @Override
    protected BaseModel getBaseModel() {
        return followersModel.getBaseModel();
    }

    public void loadFollowers(String login) {
        followersModel.loadFollowers(login);
    }

    @Override
    public void onFollowersSuccess(List<GitHubUser> followers) {
        activity.showFollowers(followers);
    }

    @Override
    public void onFollowersError() {
        activity.showError();
    }

}
