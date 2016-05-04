package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubRepo;
import com.vasko.mvp.main.MainInterfaces.ActivityInterface;
import com.vasko.mvp.main.MainInterfaces.ModelInterface;
import com.vasko.mvp.main.MainInterfaces.PresenterCallback;
import com.vasko.mvp.main.MainInterfaces.PresenterInterface;

import java.util.List;

import rx.Observable;

public class MainPresenter extends BasePresenter implements PresenterInterface, PresenterCallback {

    private final ActivityInterface view;
    private final ModelInterface model;

    public MainPresenter(ActivityInterface view) {
        this.view = view;
        model = new MainModel(this);
    }

    @Override
    public BasePresenter getPresenter() {
        return this;
    }

    @Override
    public BaseModel getModel() {
        return model.getModel();
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
    public void loadRepo(String username) {
        model.loadRepo(username);
    }

}
