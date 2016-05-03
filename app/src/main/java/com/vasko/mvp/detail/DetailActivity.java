package com.vasko.mvp.detail;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.vasko.mvp.R;
import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

public class DetailActivity extends BaseActivity implements DetailInterfaces.ActivityInterface {

    public static final String USERNAME = "USERNAME";

    private DetailInterfaces.PresenterInterface presenter;
    private TextView userName, userCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        userName = (TextView) findViewById(R.id.user_name);
        userCompany = (TextView) findViewById(R.id.user_company);

        presenter = new DetailPresenter(this);

        if (getIntent() != null) {
            String username = getIntent().getStringExtra(USERNAME);
            presenter.loadUser(username);
        } else {
            showError();
        }

    }

    @Override
    public BasePresenter getPresenter() {
        return presenter.getPresenter();
    }

    @Override
    public void showUser(GitHubUser user) {
        userName.setText(user.getName());
        userCompany.setText(user.getCompany());
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.no_user_details, Toast.LENGTH_SHORT).show();
    }
}
