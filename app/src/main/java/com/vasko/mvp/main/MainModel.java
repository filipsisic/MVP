package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.Repo;
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
        network(Rest.getClient().repositories(username), new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful()) {
                    presenter.onHighlightsSuccess(response.body());
                } else {
                    presenter.onHighlightsError();
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                presenter.onHighlightsError();
            }
        });
    }

}
