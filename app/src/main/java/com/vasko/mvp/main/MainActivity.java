package com.vasko.mvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.vasko.mvp.R;
import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubRepo;
import com.vasko.mvp.helper.Keyboard;
import com.vasko.mvp.repo.RepoActivity;
import com.vasko.mvp.user.UserActivity;

import java.util.List;

import static com.vasko.mvp.repo.RepoActivity.REPO_NAME;
import static com.vasko.mvp.user.UserActivity.USERNAME;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends BaseActivity implements ActivityInterface {

    private MainAdapter adapter;
    private MainPresenter presenter;
    private Button openButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final EditText editText = (EditText) findViewById(R.id.main_edit);
        editText.addTextChangedListener(getTextListener());
        ListView listView = (ListView) findViewById(R.id.main_list);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String userName = editText.getText().toString().trim();
            GitHubRepo repo = ((MainAdapter) adapterView.getAdapter()).getItem(i);
            startRepoActivity(userName, repo.getName());
        });
        openButton = (Button) findViewById(R.id.detail_button);
        openButton.setOnClickListener(v -> {
            String userName = editText.getText().toString().trim();
            startUserActivity(userName);
        });
        Button loadButton = (Button) findViewById(R.id.main_button);
        loadButton.setOnClickListener(v -> {
            String userName = editText.getText().toString().trim();
            presenter.loadRepo(userName);
            Keyboard.hide(MainActivity.this);
        });

        adapter = new MainAdapter(this);
        presenter = new MainPresenter(this);

        listView.setAdapter(adapter);
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }

    private void startUserActivity(String userName) {
        Intent starter = new Intent(this, UserActivity.class);
        starter.putExtra(USERNAME, userName);
        startActivity(starter);
    }

    private void startRepoActivity(String userName, String repoName) {
        Intent starter = new Intent(this, RepoActivity.class);
        starter.putExtra(USERNAME, userName);
        starter.putExtra(REPO_NAME, repoName);
        startActivity(starter);
    }

    @Override
    public void showList(List<GitHubRepo> repos) {
        adapter.notifyDataSetChanged(repos);
        openButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.no_user_on_git_hub, Toast.LENGTH_SHORT).show();
    }

    private TextWatcher getTextListener() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.clear();
                openButton.setVisibility(View.GONE);
            }
        };
    }


}
