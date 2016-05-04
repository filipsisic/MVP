package com.vasko.mvp.main;

import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

interface MainActivityInterface {

    void showList(List<GitHubRepo> repos);

    void showError();

}
