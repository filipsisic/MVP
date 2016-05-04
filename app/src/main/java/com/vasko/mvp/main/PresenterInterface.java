package com.vasko.mvp.main;

import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

interface PresenterInterface {

    void onRepoSuccess(List<GitHubRepo> repos);

    void onRepoError();

}
