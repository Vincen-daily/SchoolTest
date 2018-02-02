package com.example.school.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.school.R;
import com.example.school.dao.Teacher;
import com.example.school.logic.TeacherLogic;
import com.example.school.logic.TeacherLogicImpl;

import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/11/29.
 */

public class ActivityTeacherLogin extends AppCompatActivity implements View.OnClickListener {

    private Button login;

    private Button register;

    private EditText teacherName;

    private EditText teacherPassword;

    private TeacherLogic teacherLogic = new TeacherLogicImpl();

    List<Teacher> teacherList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        initView();
    }

    private void initView() {
        login = findViewById(R.id.teacherLogin);
        register = findViewById(R.id.teacherRegister);
        teacherName = findViewById(R.id.teacherName);
        teacherPassword = findViewById(R.id.teacherPassword);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        Connector.getDatabase();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.teacherLogin:
                login();
                break;
            case R.id.teacherRegister:
                insert();
        }
    }

    public void insert() {
        if (teacherName.length() != 0 && teacherPassword.length() != 0) {
            String name = String.valueOf(teacherName.getText());
            String password = String.valueOf(teacherPassword.getText());
            teacherLogic.insert(name, password);
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    public void login() {
        String name = String.valueOf(teacherName.getText());
        String password = String.valueOf(teacherPassword.getText());
        teacherList = teacherLogic.queryByNameAndPassword(name, password);
        if (teacherList != null) {
            Intent intent = new Intent(ActivityTeacherLogin.this, ActivityTeacherPage.class);
            intent.putExtra("teacherName", name);
            startActivity(intent);
        } else {
            Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }
}
