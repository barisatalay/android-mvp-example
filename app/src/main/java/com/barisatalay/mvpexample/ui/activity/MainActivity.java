package com.barisatalay.mvpexample.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.barisatalay.mvpexample.R;
import com.barisatalay.mvpexample.core.repository.ProjectRepositoryImpl;
import com.barisatalay.mvpexample.ui.adapter.UserNameAdapter;
import com.barisatalay.mvpexample.ui.base.BaseActivity;
import com.barisatalay.mvpexample.ui.presenter.MainPresenter;
import com.barisatalay.mvpexample.ui.view.MainView;

import java.util.ArrayList;

/**
 * Created by barisatalay on 21.02.2019.
 */
public class MainActivity extends BaseActivity implements MainView {
    private RecyclerView name_list;
    private MainPresenter presenter;
    private UserNameAdapter adapter = new UserNameAdapter(new ArrayList<String>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_list = findViewById(R.id.name_list);
        name_list.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        name_list.setLayoutManager(layoutManager);

        findViewById(R.id.plus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getContext(),InsertActivity.class), 1000);
            }
        });
    }

    @Override
    public void initPresenter() {
        presenter = new MainPresenter(this);
        presenter.attachView(this);
        presenter.attachRepository(new ProjectRepositoryImpl());
    }

    @Override
    public void onAsynchronousLoad() {
        showToast("This message comes from a different tread after the activity is created!");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void loadUserName(String userName) {
        if (adapter != null){
            adapter.insertItem(userName);
            showToast("A new item added");
        }
    }
}
