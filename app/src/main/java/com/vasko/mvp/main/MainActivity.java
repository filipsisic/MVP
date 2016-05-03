package com.vasko.mvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.vasko.mvp.R;
import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.GitHubRepo;
import com.vasko.mvp.detail.DetailActivity;
import com.vasko.mvp.helper.Keyboard;

import java.util.List;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends BaseActivity implements MainInterfaces.PtoA {

    private MainAdapter adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ListView listView = (ListView) findViewById(R.id.main_list);
        final EditText editText = (EditText) findViewById(R.id.main_edit);
        Button button = (Button) findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText.getText().toString().trim();
                presenter.loadRepo(username);
                Keyboard.hide(MainActivity.this);

                startDetailActivity(username);
            }
        });

        adapter = new MainAdapter(this);
        presenter = new MainPresenter(this);

        listView.setAdapter(adapter);
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }

    public void startDetailActivity(String username) {
        Intent starter = new Intent(this, DetailActivity.class);
        starter.putExtra(DetailActivity.USERNAME, username);
        startActivity(starter);
    }

    @Override
    public void showList(List<GitHubRepo> repos) {
        adapter.notifyDataSetChanged(repos);
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.no_user_on_git_hub, Toast.LENGTH_SHORT).show();
    }

}
