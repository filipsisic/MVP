package com.vasko.mvp.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.vasko.mvp.R;
import com.vasko.mvp.base.BaseActivity;
import com.vasko.mvp.base.BasePresenter;
import com.vasko.mvp.data.Repo;
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

    @Override
    public void showList(List<Repo> repos) {
        adapter.notifyDataSetChanged(repos);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Wrong event id", Toast.LENGTH_SHORT).show();
    }

}
