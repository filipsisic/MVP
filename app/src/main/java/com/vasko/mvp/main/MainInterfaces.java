package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModelInterface;
import com.vasko.mvp.base.BasePresenterInterface;
import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

interface MainInterfaces {

    interface PresenterInterface extends BasePresenterInterface {

        void loadRepo(String username);

    }

    interface ModelInterface extends BaseModelInterface {

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
