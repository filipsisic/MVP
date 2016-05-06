package com.vasko.mvp.followers;

import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

import java.util.List;

/**
 * Created by Filip on 6.5.2016..
 */
public class PresenterDeclaration {

    interface PresenterToModelInterface {

        void onFollowersSuccess(List<GitHubUser> followers);

        void onFollowersError();
    }

    interface PresenterToViewInterface {

        BasePresenter getPresenter();

        void loadFollowers(String login);
    }
}
