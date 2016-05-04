package com.vasko.mvp.base;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public abstract class BaseModel {

    private final List<Subscription> subscriptions = new ArrayList<>();

    protected <T> void network(Observable<T> call, Action1<T> success, Action1<Throwable> error) {
        Subscription subscription = call
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error);
        subscriptions.add(subscription);
    }

    void cancelAll() {
        for (Subscription subscription : subscriptions) {
            subscription.unsubscribe();
        }
        subscriptions.clear();
    }
}
