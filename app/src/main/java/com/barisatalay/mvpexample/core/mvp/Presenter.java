package com.barisatalay.mvpexample.core.mvp;

import android.content.SharedPreferences;

/**
 * Created by barisatalay on 21.02.2019.
 */
public interface Presenter<V extends BaseView, R extends Repository> {
    void attachView(V mvpView);
    void detachView();
    void attachRepository(R repository);
    void detachRepository();
    void detachAll();
}
