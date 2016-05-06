package com.vasko.mvp.database;

import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Filip on 6.5.2016..
 */
class AsyncDB implements AsyncDbInterface{

    private SyncDB syncDB;

    public AsyncDB(SyncDB syncDB) {
        this.syncDB = syncDB;
    }

    @Override
    public Observable<List<GitHubRepo>> getRepos() {
        return async(() -> syncDB.getRepos());
    }


    private static <T> Observable<T> async(final Code<T> code) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                subscriber.onNext(code.execute());
                subscriber.onCompleted();
            }
        });
    }

    interface Code<T> {
        T execute();
    }
}
