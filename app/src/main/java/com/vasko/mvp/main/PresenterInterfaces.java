package com.vasko.mvp.main;

import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

class PresenterInterfaces {

    private PresenterInterfaces() {

    }

    interface PresenterCallback {

        void onRepoSuccess(List<GitHubRepo> repos);

        void onRepoError();

    }

    interface PresenterInterface {

        BasePresenter getBasePresenter();

        void loadRepo(String login);

    }

}
