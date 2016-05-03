package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubRepo;
import com.vasko.mvp.reftrofit.Rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel extends BaseModel implements MainInterfaces.ModelInterface {

    private final MainInterfaces.PresenterCallback presenterCallback;

    public MainModel(MainInterfaces.PresenterCallback presenterCallback) {
        this.presenterCallback = presenterCallback;
    }

    @Override
    public BaseModel getModel() {
        return this;
    }

    @Override
    public void loadRepo(String username) {
        network(Rest.getClient().repositories(username), new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                if (response.isSuccessful()) {
                    presenterCallback.onRepoSuccess(response.body());
                } else {
                    presenterCallback.onRepoError();
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });
    }

}
