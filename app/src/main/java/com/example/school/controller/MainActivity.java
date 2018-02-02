package com.example.school.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.school.R;
import com.example.school.adminPage.presentation.view.AdminPageActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button adminLogin;

    private Button userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        adminLogin = findViewById(R.id.admin_login);

        userLogin =  findViewById(R.id.user_login);

        adminLogin.setOnClickListener(this);

        userLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.admin_login:
                startActivity(new Intent(MainActivity.this, AdminPageActivity.class));
                break;

            case R.id.user_login:
                startActivity(new Intent(MainActivity.this, ActivityUserLogin.class));
                break;
        }

    }
}
