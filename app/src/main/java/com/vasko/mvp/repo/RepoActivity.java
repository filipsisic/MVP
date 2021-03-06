package com.vasko.mvp.repo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.vasko.mvp.R;
import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.followers.FollowersActivity;
import com.vasko.mvp.common.GitHubUserAdapter;
import com.vasko.mvp.helper.Utility;
import com.vasko.mvp.repo.PresenterInterfaces.PresenterInterface;

import java.util.List;

import static com.vasko.mvp.user.UserActivity.LOGIN;

@SuppressWarnings("ConstantConditions")
public class RepoActivity extends BaseActivity implements ActivityInterface {

    public static final String REPO_NAME = "REPO_NAME";

    private PresenterInterface presenter;
    private GitHubUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repo_activity);

        presenter = new RepoPresenter(this);
        adapter = new GitHubUserAdapter(this);

        ListView listView = (ListView) findViewById(R.id.repo_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(RepoActivity.this, FollowersActivity.class);
            intent.putExtra(FollowersActivity.USER_LOGIN,  ((GitHubUserAdapter) parent.getAdapter()).getItem(position).getLogin());
            startActivity(intent);
        });

        if (getIntent() != null) {
            String login = getIntent().getStringExtra(LOGIN);
            String repoName = getIntent().getStringExtra(REPO_NAME);
            presenter.loadContributors(login, repoName);
        } else {
            showError();
        }

    }

    @Override
    public void showContributors(List<GitHubUser> contributors) {
        adapter.createList(contributors);
    }

    @Override
    public void showError() {
        Utility.showToast(this, R.string.no_contributors);
    }

    @Override
    protected BasePresenter getBasePresenter() {
        return presenter.getBasePresenter();
    }
}
