package com.vasko.mvp.followers;

import com.vasko.mvp.base.BaseModel;

interface ModelInterface {

    BaseModel getModel();

    void loadFollowers(String login);

}
