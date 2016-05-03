package com.vasko.mvp.detail;

import com.vasko.mvp.base.BaseModel;
import com.vasko.mvp.data.GitHubUser;
import com.vasko.mvp.reftrofit.Rest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailModel extends BaseModel implements DetailInterfaces.PtoM {

    private final DetailInterfaces.MtoP presenter;

    public DetailModel(DetailInterfaces.MtoP presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadUser(String username) {
        network(Rest.getClient().user(username), new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                if (response.isSuccessful()) {
                    presenter.onUserSuccess(response.body());
                } else {
                    presenter.onUserError();
                }
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {

            }
        });
    }
}
