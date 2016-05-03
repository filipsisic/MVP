package com.vasko.mvp.main;

import com.vasko.mvp.data.GitHubRepo;

import java.util.List;

class MainInterfaces {

    interface AtoP {

        void loadRepo(String username);

    }

    interface PtoM {

        void loadRepo(String username);

    }

    interface MtoP {

        void onRepoSuccess(List<GitHubRepo> repos);

        void onRepoError();

    }


    interface PtoA {

        void showList(List<GitHubRepo> repos);

        void showError();

    }

}
