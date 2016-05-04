package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModelInterface;
import com.vasko.mvp.base.BasePresenterInterface;
import com.vasko.mvp.data.GitHubUser;

@SuppressWarnings("unused")
interface UserInterfaces {

    interface PresenterInterface extends BasePresenterInterface {

        void loadUser(String username);

    }

    interface ModelInterface extends BaseModelInterface {

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
