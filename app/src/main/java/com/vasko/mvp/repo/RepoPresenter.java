package com.vasko.mvp.repo;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

import java.util.List;

import rx.Observable;

class RepoPresenter extends BasePresenter implements PresenterInterface {

    private final ActivityInterface view;
    private final RepoModel model;

    public RepoPresenter(ActivityInterface view) {
        this.view = view;
        model = new RepoModel(this);
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
    protected BaseModel getModel() {
        return model;
    }

    public void loadContributors(String login, String repoName) {
        model.loadUsers(login, repoName);
    }
}
