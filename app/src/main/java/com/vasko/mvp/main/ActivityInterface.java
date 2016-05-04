package com.vasko.mvp.main;

import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

interface ActivityInterface {

    void showList(List<GitHubRepo> repos);

    void showError();

}
