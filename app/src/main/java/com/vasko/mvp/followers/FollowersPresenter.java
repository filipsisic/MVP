package com.vasko.mvp.followers;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.followers.PresenterDeclaration.PresenterToModelInterface;
import com.vasko.mvp.followers.PresenterDeclaration.PresenterToViewInterface;

import java.util.List;

/**
 * Created by Filip on 5.5.2016..
 */
class FollowersPresenter extends BasePresenter implements PresenterToModelInterface, PresenterToViewInterface {

    private ActivityInterface activity;
    private ModelInterface followersModel;

    public FollowersPresenter(ActivityInterface activity) {
        this.activity = activity;
        followersModel = new FollowersModel(this);
    }

    @Override
    public BasePresenter getPresenter() {
        return this;
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

    @Override
    protected BaseModel getModel() {
        return followersModel.getModel();
    }
}
