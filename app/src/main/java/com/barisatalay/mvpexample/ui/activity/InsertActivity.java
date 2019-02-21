package com.barisatalay.mvpexample.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.barisatalay.mvpexample.R;
import com.barisatalay.mvpexample.core.repository.ProjectRepositoryImpl;
import com.barisatalay.mvpexample.ui.base.BaseActivity;
import com.barisatalay.mvpexample.ui.presenter.InsertPresenter;
import com.barisatalay.mvpexample.ui.view.InsertView;

public class InsertActivity extends BaseActivity implements InsertView {
    private EditText user_name;
    private Button save_button;

    private InsertPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        user_name = findViewById(R.id.user_name);

        save_button = findViewById(R.id.save_button);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.saveUserName();
            }
        });
    }

    @Override
    public void initPresenter() {
        presenter = new InsertPresenter(this);
        presenter.attachView(this);
        presenter.attachRepository(new ProjectRepositoryImpl());
    }

    @Override
    public void onAsynchronousLoad() {
    }

    @Override
    public String getUserName() {
        return user_name.getText() == null ? "" : user_name.getText().toString();
    }

    @Override
    public void returnMainActivity(Intent intent) {
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
