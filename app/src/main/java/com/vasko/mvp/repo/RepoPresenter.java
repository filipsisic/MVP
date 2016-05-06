package com.vasko.mvp.repo;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.repo.PresenterInterfaces.PresenterCallback;
import com.vasko.mvp.repo.PresenterInterfaces.PresenterInterface;

import java.util.List;

import rx.Observable;

class RepoPresenter extends BasePresenter implements PresenterInterface, PresenterCallback {

    private final ActivityInterface view;
    private final ModelInterface model;

    public RepoPresenter(ActivityInterface view) {
        this.view = view;
        model = new RepoModel(this);
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
    public void onContributorsSuccess(List<GitHubUser> contributors) {
        Observable.from(contributors).filter(user -> user.getContributions() > 5).toList().subscribe(view::showContributors);
    }

    @Override
    public void onContributorsError() {
        view.showError();
    }

    @Override
    public void loadContributors(String login, String repoName) {
        model.loadUsers(login, repoName);
    }


}
