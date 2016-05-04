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
import com.vasko.mvp.detail.DetailActivity;
import com.vasko.mvp.helper.Keyboard;
import com.vasko.mvp.main.MainInterfaces.PresenterInterface;

import java.util.List;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends BaseActivity implements MainInterfaces.ActivityInterface {

    private MainAdapter adapter;
    private PresenterInterface presenterInterface;
    private Button openButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ListView listView = (ListView) findViewById(R.id.main_list);
        final EditText editText = (EditText) findViewById(R.id.main_edit);
        editText.addTextChangedListener(getTextListener());
        openButton = (Button) findViewById(R.id.detail_button);
        openButton.setOnClickListener(v -> {
            String username = editText.getText().toString().trim();
            startDetailActivity(username);
        });
        Button loadButton = (Button) findViewById(R.id.main_button);
        loadButton.setOnClickListener(v -> {
            String username = editText.getText().toString().trim();
            presenterInterface.loadRepo(username);
            Keyboard.hide(MainActivity.this);
        });

        adapter = new MainAdapter(this);
        presenterInterface = new MainPresenter(this);

        listView.setAdapter(adapter);
    }

    @Override
    public BasePresenter getPresenter() {
        return presenterInterface.getPresenter();
    }

    private void startDetailActivity(String username) {
        Intent starter = new Intent(this, DetailActivity.class);
        starter.putExtra(DetailActivity.USERNAME, username);
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
