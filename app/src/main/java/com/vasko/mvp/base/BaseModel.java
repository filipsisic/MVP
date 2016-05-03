package com.vasko.mvp.base;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public abstract class BaseModel {

    private final List<Call> calls = new ArrayList<>();

    protected <T> void network(Call<T> call, Callback<T> callback) {
        calls.add(call);
        call.enqueue(callback);
    }

    void cancelAll() {
        for (Call call : calls) {
            call.cancel();
        }
        calls.clear();
    }
}
