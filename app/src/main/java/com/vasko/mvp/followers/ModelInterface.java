package com.vasko.mvp.followers;

import com.vasko.mvp.base.BaseModel;

/**
 * Created by Filip on 6.5.2016..
 */
public interface ModelInterface {

    BaseModel getModel();

    void loadFollowers(String login);

}
