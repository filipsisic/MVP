package com.vasko.mvp.user;

import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

class PresenterInterfaces {

    private PresenterInterfaces() {

    }

    interface PresenterCallback {

        void onUserSuccess(GitHubUser user);

        void onUserError();

    }

    interface PresenterInterface {

        BasePresenter getBasePresenter();

        void loadUser(String login);

    }


}
