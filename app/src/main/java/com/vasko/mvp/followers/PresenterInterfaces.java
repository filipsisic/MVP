package com.vasko.mvp.followers;

import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

import java.util.List;

@SuppressWarnings("unused")
interface PresenterInterfaces {

    interface PresenterCallback {

        void onFollowersSuccess(List<GitHubUser> followers);

        void onFollowersError();
    }

    interface PresenterInterface {

        BasePresenter getPresenter();

        void loadFollowers(String login);
    }
}
