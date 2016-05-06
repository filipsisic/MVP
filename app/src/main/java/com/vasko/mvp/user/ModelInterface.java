package com.vasko.mvp.user;

import com.vasko.mvp.base.BaseModel;

interface ModelInterface {

    BaseModel getBaseModel();

    void loadUser(String login);

}
