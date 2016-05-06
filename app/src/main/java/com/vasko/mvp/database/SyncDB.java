package com.vasko.mvp.database;

import com.vasko.mvp.data.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 6.5.2016..
 */
class SyncDB implements SyncDbInterface {

    @Override
    public List<GitHubRepo> getRepos() {
        List<GitHubRepo> list = new ArrayList<>();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(new GitHubRepo("Test", true));
        return list;
    }
}
