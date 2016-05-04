package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

import rx.Observable;

class MainPresenter extends BasePresenter implements MainPresenterInterface {

    private final MainActivityInterface view;
    private final MainModel model;

    public MainPresenter(MainActivityInterface view) {
        this.view = view;
        model = new MainModel(this);
    }

    @Override
    public BaseModel getModel() {
        return model;
    }

    @Override
    public void onRepoSuccess(List<GitHubRepo> repos) {
        Observable.from(repos).filter(GitHubRepo::isFork).toList().subscribe(view::showList);
    }

    @Override
    public void onRepoError() {
        view.showError();
    }

    public void loadRepo(String username) {
        model.loadRepo(username);
    }

}
