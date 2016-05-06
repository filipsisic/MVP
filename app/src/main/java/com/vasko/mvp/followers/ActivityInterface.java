package com.vasko.mvp.followers;

import com.vasko.mvp.data.GitHubUser;

import java.util.List;

interface ActivityInterface {

    void showFollowers(List<GitHubUser> followers);

    void showError();
}
