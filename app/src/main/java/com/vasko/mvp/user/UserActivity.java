package com.vasko.mvp.user;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.vasko.mvp.R;
import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;

public class UserActivity extends BaseActivity implements UserActivityInterface {

    public static final String USERNAME = "USERNAME";

    private UserPresenter presenter;
    private TextView userName, userCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);
        userName = (TextView) findViewById(R.id.user_name);
        userCompany = (TextView) findViewById(R.id.user_company);

        presenter = new UserPresenter(this);

        if (getIntent() != null) {
            String username = getIntent().getStringExtra(USERNAME);
            presenter.loadUser(username);
        } else {
            showError();
        }

    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
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
