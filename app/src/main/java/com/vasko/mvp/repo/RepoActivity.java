package com.vasko.mvp.repo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.vasko.mvp.R;
import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

import java.util.List;

import static com.vasko.mvp.user.UserActivity.USERNAME;

public class RepoActivity extends BaseActivity implements ActivityInterface {

    public static final String REPO_NAME = "REPO_NAME";

    private RepoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repo_activity);

        presenter = new RepoPresenter(this);

        if (getIntent() != null) {
            String userName = getIntent().getStringExtra(USERNAME);
            String repoName = getIntent().getStringExtra(REPO_NAME);
            presenter.loadContributors(userName, repoName);
        } else {
            showError();
        }

    }

    @Override
    public void showContributors(List<GitHubUser> contributors) {
        Log.d("xxxxxxxxx", "contributors");
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.no_contributors, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }
}
