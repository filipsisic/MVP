package com.vasko.mvp.data;

@SuppressWarnings("unused")
public class GitHubUser {

    private int id;
    private String login;
    private String name;
    private String company;
    private int contributions;

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getContributions() {
        return contributions;
    }
}
