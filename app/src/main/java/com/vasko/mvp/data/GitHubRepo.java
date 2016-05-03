package com.vasko.mvp.data;

@SuppressWarnings("unused")
public class GitHubRepo {

    private int id;
    private String name;
    private boolean fork;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isFork() {
        return fork;
    }
}