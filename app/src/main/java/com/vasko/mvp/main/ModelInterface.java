package com.vasko.mvp.main;

import com.vasko.mvp.base.BaseModel;

interface ModelInterface {

    BaseModel getBaseModel();

    void loadRepo(String login);

}
