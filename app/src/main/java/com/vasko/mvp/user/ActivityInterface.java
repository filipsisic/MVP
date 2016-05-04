package com.vasko.mvp.user;

import com.vasko.mvp.data.GitHubUser;

interface ActivityInterface {

    void showUser(GitHubUser user);

    void showError();

}
