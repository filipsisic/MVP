package com.vasko.mvp.detail;

import com.vasko.mvp.data.GitHubUser;

interface DetailInterfaces {

    interface AtoP {

        void loadUser(String username);

    }

    interface PtoM {

        void loadUser(String username);

    }

    interface MtoP {

        void onUserSuccess(GitHubUser user);

        void onUserError();

    }


    interface PtoA {

        void showUser(GitHubUser user);

        void showError();

    }

}
