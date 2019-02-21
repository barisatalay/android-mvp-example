package com.barisatalay.mvpexample.ui.adapter;

import android.view.View;

import com.barisatalay.mvpexample.R;
import com.barisatalay.mvpexample.ui.base.BaseRecyclerAdapter;

import java.util.List;

public class UserNameAdapter extends BaseRecyclerAdapter<UserNameHolder, String> {
    public UserNameAdapter(List<String> cacheData) {
        super(cacheData);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.item_name;
    }

    @Override
    public void onCustomBindViewHolder(UserNameHolder holder, String model, int position) {
        holder.bind(model);
    }

    @Override
    public UserNameHolder onCustomCreateViewHolder(View view) {
        return new UserNameHolder(view);
    }

    @Override
    public boolean isSelectable() {
        return true;
    }
    /**
     * Eğer isSelectable true ise kaç tane seçilebilmesine izin veriyorsanız selectableCount içerisine yazmalısınız.
     * */
    @Override
    public int selectableCount() {
        return 2;
    }

}
