package com.vasko.mvp.detail;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

interface DetailInterfaces {

    interface PresenterInterface {

        BasePresenter getPresenter();

        void loadUser(String username);

    }

    interface ModelInterface {

        BaseModel getModel();

        void loadUser(String username);

    }

    interface PresenterCallback {

        void onUserSuccess(GitHubUser user);

        void onUserError();

    }


    interface ActivityInterface {

        void showUser(GitHubUser user);

        void showError();

    }

}
