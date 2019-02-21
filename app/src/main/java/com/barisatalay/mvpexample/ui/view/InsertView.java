package com.barisatalay.mvpexample.ui.view;

import android.content.Intent;

import com.barisatalay.mvpexample.core.mvp.BaseView;

public interface InsertView extends BaseView {
    String getUserName();

    void returnMainActivity(Intent intent);
}
