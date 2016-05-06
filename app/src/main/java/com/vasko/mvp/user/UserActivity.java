package com.vasko.mvp.user;

import android.os.Bundle;
import android.widget.TextView;

import com.vasko.mvp.R;
import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.helper.Utility;
import com.vasko.mvp.user.PresenterInterfaces.PresenterInterface;

public class UserActivity extends BaseActivity implements ActivityInterface {

    public static final String LOGIN = "LOGIN";

    private PresenterInterface presenter;
    private TextView userName, userCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);
        userName = (TextView) findViewById(R.id.user_name);
        userCompany = (TextView) findViewById(R.id.user_company);

        presenter = new UserPresenter(this);

        if (getIntent() != null) {
            String login = getIntent().getStringExtra(LOGIN);
            presenter.loadUser(login);
        } else {
            showError();
        }

    }

    @Override
    public BasePresenter getBasePresenter() {
        return presenter.getBasePresenter();
    }

    @Override
    public void showUser(GitHubUser user) {
        if (user.getName() != null) {
            userName.setText(user.getName());
        } else {
            userName.setText(user.getLogin());
        }
        userCompany.setText(user.getCompany());
    }

    @Override
    public void showError() {
        Utility.showToast(this, R.string.no_user_details);
    }
}
