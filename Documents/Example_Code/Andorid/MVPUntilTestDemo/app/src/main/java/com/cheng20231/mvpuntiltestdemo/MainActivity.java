package com.cheng20231.mvpuntiltestdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.cheng20231.mvpuntiltestdemo.Login.LoginInterFace;
import com.cheng20231.mvpuntiltestdemo.Login.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginInterFace {

    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new LoginPresenter(this);
        mPresenter.attachView(this);

        final EditText account = (EditText) findViewById(R.id.et_account);
        final EditText password = (EditText) findViewById(R.id.et_password);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.loginEvent(account.getText().toString(), password.getText().toString());
            }
        });

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.registerEvent(account.getText().toString(), password.getText().toString());
            }
        });
    }

    @Override
    public void showAlert(String title, String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(title).setMessage(message).setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }
}
