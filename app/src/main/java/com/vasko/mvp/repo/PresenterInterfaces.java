package com.vasko.mvp.repo;

import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

import java.util.List;

class PresenterInterfaces {

    private PresenterInterfaces() {

    }

    interface PresenterCallback {

        void onContributorsSuccess(List<GitHubUser> contributors);

        void onContributorsError();

    }

    interface PresenterInterface {

        BasePresenter getBasePresenter();

        void loadContributors(String login, String repoName);

    }

}
