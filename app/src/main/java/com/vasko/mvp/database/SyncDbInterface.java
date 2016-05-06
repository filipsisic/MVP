package com.vasko.mvp.database;

import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

/**
 * Created by Filip on 6.5.2016..
 */
public interface SyncDbInterface {

    List<GitHubRepo> getRepos();

}
