package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

class MainInterfaces {

    interface PresenterInterface {

        BasePresenter getPresenter();

        void loadRepo(String username);

    }

    interface ModelInterface {

        BaseModel getModel();

        void loadRepo(String username);

    }

    interface PresenterCallback {

        void onRepoSuccess(List<GitHubRepo> repos);

        void onRepoError();

    }


    interface ActivityInterface {

        void showList(List<GitHubRepo> repos);

        void showError();

    }

}
