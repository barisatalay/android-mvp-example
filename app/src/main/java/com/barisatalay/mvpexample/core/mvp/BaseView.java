package com.barisatalay.mvpexample.core.mvp;

/**
 * Created by barisatalay on 21.02.2019.
 */
public interface BaseView {
    void showToast(String message);
    void showToast(int resourceId);
    void hideKeyboard();
    void closeActivity();
}
