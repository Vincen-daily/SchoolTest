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
import com.example.school.logic.StudentLogic;
import com.example.school.logic.StudentLogicImpl;

import org.litepal.tablemanager.Connector;

/**
 * Created by xiecy on 2017/11/29.
 */

public class ActivityParentRegister extends AppCompatActivity {

    private EditText parentAccount;

    private EditText parentPassword;

    private EditText studentName;

    private EditText studentAge;

    private Button register;

    private StudentLogic studentLogic = new StudentLogicImpl();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_register);
        initView();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
                insert();
                startActivity(new Intent(ActivityParentRegister.this, ActivityUserLogin.class));
            }
        });
    }

    private void initView() {
        register = findViewById(R.id.ParentRegister);
        parentAccount = findViewById(R.id.RegisterParent_Account);
        studentName = findViewById(R.id.RegisterParent_Name);
        parentPassword = findViewById(R.id.RegisterParent_Password);
        studentAge = findViewById(R.id.RegisterParent_studentAge);
    }

    public void insert() {
        if (studentName.length() == 0 || parentPassword.length() == 0 || studentAge.length() == 0 || parentAccount.length() == 0) {
            Toast.makeText(this, "请填写完整信息", Toast.LENGTH_LONG).show();
        } else {
            String account = String.valueOf(parentAccount.getText());
            String name = String.valueOf(studentName.getText());
            String password = String.valueOf(parentPassword.getText());
            String age = String.valueOf(studentAge.getText());
            studentLogic.insert(account, password, name, age);
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        }
    }
}
