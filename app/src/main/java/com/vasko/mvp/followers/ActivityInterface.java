package com.vasko.mvp.followers;

import com.vasko.mvp.data.GitHubUser;

import java.util.List;

/**
 * Created by Filip on 5.5.2016..
 */
interface ActivityInterface {

    void showFollowers(List<GitHubUser> followers);

    void showError();
}
