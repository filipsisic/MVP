package com.vasko.mvp.repo;

import com.vasko.mvp.data.GitHubUser;

import java.util.List;

interface ActivityInterface {

    void showContributors(List<GitHubUser> contributors);

    void showError();

}
