package com.vasko.mvp.user;

import com.vasko.mvp.data.GitHubUser;

interface PresenterInterface {

    void onUserSuccess(GitHubUser user);

    void onUserError();

}
