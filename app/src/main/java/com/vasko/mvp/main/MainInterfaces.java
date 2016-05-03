package com.vasko.mvp.main;

import com.vasko.mvp.data.Repo;

import java.util.List;

public class MainInterfaces {

    public interface AtoP {

        void loadRepo(String username);

    }

    public interface PtoM {

        void loadRepo(String username);

    }

    public interface MtoP {

        void onHighlightsSuccess(List<Repo> repos);

        void onHighlightsError();

    }


    public interface PtoA {

        void showList(List<Repo> repos);

        void showError();

    }

}
