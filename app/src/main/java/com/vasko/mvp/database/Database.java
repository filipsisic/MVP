package com.vasko.mvp.database;

import com.vasko.mvp.data.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class Database {
    private static final Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private Database() {
    }

    public Observable<List<GitHubRepo>> getReposAsync() {
        return async(this::getRepos);
    }

    private List<GitHubRepo> getRepos() {
        List<GitHubRepo> list = new ArrayList<>();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(new GitHubRepo("Test", true));
        return list;
    }

    private <T> Observable<T> async(final Code<T> code) {
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
