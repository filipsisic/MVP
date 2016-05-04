package com.vasko.mvp.user;

import com.vasko.mvp.data.GitHubUser;

interface UserActivityInterface {

    void showUser(GitHubUser user);

    void showError();

}
