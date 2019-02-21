package com.barisatalay.mvpexample.ui.presenter;

import android.app.Activity;
import android.content.Intent;

import com.barisatalay.mvpexample.core.mvp.BasePresenter;
import com.barisatalay.mvpexample.core.mvp.Repository;
import com.barisatalay.mvpexample.ui.view.MainView;

/**
 * Created by barisatalay on 21.02.2019.
 */
public class MainPresenter extends BasePresenter<MainView, Repository> {

    public MainPresenter(Activity mActivity) {
        super(mActivity);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 1000) {
                if (data.hasExtra("UserName")) {
                    String userName = data.getStringExtra("UserName");

                    if (getView() != null) {
                        getView().loadUserName(userName);
                    }
                }
            }
        }
    }
}
