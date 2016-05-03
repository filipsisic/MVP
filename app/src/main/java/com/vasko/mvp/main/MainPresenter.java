package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.Repo;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter extends BasePresenter implements MainInterfaces.AtoP, MainInterfaces.MtoP {

    private final MainInterfaces.PtoA view;
    private final MainModel model;

    public MainPresenter(MainInterfaces.PtoA view) {
        this.view = view;
        model = new MainModel(this);
    }

    @Override
    public BaseModel getModel() {
        return model;
    }

    @Override
    public void onHighlightsSuccess(List<Repo> repos) {
        List<Repo> list = new ArrayList<>();
        for (Repo repo : repos) {
            if (repo.isFork()) {
                list.add(repo);
            }
        }
        view.showList(list);
    }

    @Override
    public void onHighlightsError() {
        view.showError();
    }

    @Override
    public void loadRepo(String username) {
        model.loadRepo(username);
    }

}
