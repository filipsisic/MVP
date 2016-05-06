package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

import rx.Observable;

class MainPresenter extends BasePresenter implements PresenterInterfaces.PresenterCallback, PresenterInterfaces.PresenterInterface {

    private final ActivityInterface view;
    private final ModelInterface model;

    public MainPresenter(ActivityInterface view) {
        this.view = view;
        model = new MainModel(this);
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
    public void onRepoSuccess(List<GitHubRepo> repos) {
        Observable.from(repos).filter(GitHubRepo::isFork).toList().subscribe(view::showList);
    }

    @Override
    public void onRepoError() {
        view.showError();
    }

    @Override
    public void loadRepo(String login) {
        model.loadRepo(login);
    }

}
