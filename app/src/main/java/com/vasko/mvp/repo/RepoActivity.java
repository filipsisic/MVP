package com.vasko.mvp.repo;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.vasko.mvp.R;
import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

import java.util.List;

import static com.vasko.mvp.user.UserActivity.LOGIN;

@SuppressWarnings("ConstantConditions")
public class RepoActivity extends BaseActivity implements ActivityInterface {

    public static final String REPO_NAME = "REPO_NAME";

    private RepoPresenter presenter;
    private RepoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repo_activity);

        presenter = new RepoPresenter(this);
        adapter = new RepoAdapter(this);

        ListView listView = (ListView) findViewById(R.id.repo_list);
        listView.setAdapter(adapter);

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
        adapter.notifyDataSetChanged(contributors);
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
