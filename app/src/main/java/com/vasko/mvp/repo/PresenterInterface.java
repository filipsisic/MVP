package com.vasko.mvp.repo;

import com.vasko.mvp.data.GitHubUser;

import java.util.List;

interface PresenterInterface {

    void onContributorsSuccess(List<GitHubUser> contributors);

    void onContributorsError();

}
