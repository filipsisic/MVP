package com.vasko.mvp.followers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.vasko.mvp.R;
import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.common.GitHubUserAdapter;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.followers.PresenterInterfaces.PresenterInterface;
import com.vasko.mvp.helper.Utility;

import java.util.List;

@SuppressWarnings("ConstantConditions")
public class FollowersActivity extends BaseActivity implements ActivityInterface {

    public static final String USER_LOGIN = "USER_LOGIN_FOLLOWERS";

    private PresenterInterface followersPresenter;
    private GitHubUserAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        adapter = new GitHubUserAdapter(this);
        followersPresenter = new FollowersPresenter(this);

        ListView listView = (ListView) findViewById(R.id.followers_list);
        listView.setAdapter(adapter);

        if (getIntent().hasExtra(USER_LOGIN)) {
            followersPresenter.loadFollowers(getIntent().getStringExtra(USER_LOGIN));
        } else {
            showError();
        }
    }

    @Override
    public void showFollowers(List<GitHubUser> followers) {
        adapter.createList(followers);
    }

    @Override
    public void showError() {
        Utility.showToast(this, R.string.no_followers);
    }

    @Override
    protected BasePresenter getBasePresenter() {
        return followersPresenter.getPresenter();
    }
}
