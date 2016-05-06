package com.vasko.mvp.followers;

import com.vasko.mvp.data.GitHubUser;

import java.util.List;

/**
 * Created by Filip on 5.5.2016..
 */
interface PresenterInterface {

    void onFollowersSuccess(List<GitHubUser> followers);

    void onFollowersError();
}
