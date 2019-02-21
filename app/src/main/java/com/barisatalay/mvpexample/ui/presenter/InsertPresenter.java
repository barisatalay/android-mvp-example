package com.barisatalay.mvpexample.ui.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.barisatalay.mvpexample.core.mvp.BasePresenter;
import com.barisatalay.mvpexample.core.mvp.Repository;
import com.barisatalay.mvpexample.ui.view.InsertView;

public class InsertPresenter extends BasePresenter<InsertView, Repository> {

    public InsertPresenter(Activity mActivity) {
        super(mActivity);
    }

    public void saveUserName() {
        if (getView() == null) return;//If activity closed , we don't be continue

        String userName = getView().getUserName();

        if (TextUtils.isEmpty(userName)){
            getView().showToast("Kullanıcı adı boş olamaz!");
            return;
        }

        Intent intent = new Intent();
        intent.putExtra("UserName", userName);

        getView().returnMainActivity(intent);
    }
}
