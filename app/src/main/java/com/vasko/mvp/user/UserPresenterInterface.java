package com.vasko.mvp.user;

import com.vasko.mvp.data.GitHubUser;

interface UserPresenterInterface {

    void onUserSuccess(GitHubUser user);

    void onUserError();

}
