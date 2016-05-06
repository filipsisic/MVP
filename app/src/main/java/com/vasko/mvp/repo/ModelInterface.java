package com.vasko.mvp.repo;

import com.vasko.mvp.base.BaseModel;

interface ModelInterface {

    BaseModel getBaseModel();

    void loadUsers(String login, String repoName);

}
