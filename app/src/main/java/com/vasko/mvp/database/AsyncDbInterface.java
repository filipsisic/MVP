package com.vasko.mvp.database;

import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

import rx.Observable;

/**
 * Created by Filip on 6.5.2016..
 */
public interface AsyncDbInterface {

    Observable<List<GitHubRepo>> getRepos();

}
