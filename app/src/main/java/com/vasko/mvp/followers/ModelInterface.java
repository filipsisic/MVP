package com.vasko.mvp.followers;

import com.vasko.mvp.base.BaseModel;

interface ModelInterface {

    BaseModel getBaseModel();

    void loadFollowers(String login);

}
