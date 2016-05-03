package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubRepo;
import com.vasko.mvp.reftrofit.Rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel extends BaseModel implements MainInterfaces.PtoM {

    private final MainInterfaces.MtoP presenter;

    public MainModel(MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadRepo(String username) {
        network(Rest.getClient().repositories(username), new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                if (response.isSuccessful()) {
                    presenter.onRepoSuccess(response.body());
                } else {
                    presenter.onRepoError();
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });
    }

}
