package com.vasko.mvp.base;

public interface Lifecycle {

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

}
