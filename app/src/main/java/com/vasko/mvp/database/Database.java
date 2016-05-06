package com.vasko.mvp.database;

public class Database {

    private static Database instance;
    private static AsyncDB asyncDB;
    private static SyncDB syncDB;

    private static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Database() {
    }

    public static AsyncDbInterface async() {
        getInstance();
        if (asyncDB == null) {
            if (syncDB == null) {
                syncDB = new SyncDB();
            }
            asyncDB = new AsyncDB(syncDB);
        }
        return asyncDB;
    }

    public static SyncDbInterface sync() {
        getInstance();
        if (syncDB == null) {
            syncDB = new SyncDB();
        }
        return syncDB;
    }

}
