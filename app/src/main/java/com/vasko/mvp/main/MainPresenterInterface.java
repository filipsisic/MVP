package com.vasko.mvp.main;

import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

interface MainPresenterInterface {

    void onRepoSuccess(List<GitHubRepo> repos);

    void onRepoError();

}
