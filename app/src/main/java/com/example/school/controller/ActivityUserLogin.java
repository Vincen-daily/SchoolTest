package com.example.school.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.school.R;
import com.example.school.logic.StudentLogic;
import com.example.school.logic.StudentLogicImpl;
import com.example.school.logic.TeacherLogic;
import com.example.school.logic.TeacherLogicImpl;

public class ActivityUserLogin extends AppCompatActivity implements View.OnClickListener {

    private EditText userAccount;

    private EditText userPassword;

    private Button login;

    private Button register;

    private StudentLogic studentLogic=new StudentLogicImpl();

    private TeacherLogic teacherLogic=new TeacherLogicImpl();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initView();

    }

    private void initView() {
        userAccount=findViewById(R.id.userLogin_account);
        userPassword=findViewById(R.id.userLogin_password);
        login=findViewById(R.id.userLogin);
        register=findViewById(R.id.userRegister);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.userLogin:
                login();
                break;
            case R.id.userRegister:
                register();
        }
    }

    private void register() {
        startActivity(new Intent(ActivityUserLogin.this,ActivityParentRegister.class));
    }

    private void login() {
        String account=String.valueOf(userAccount.getText());
        String password=String.valueOf(userPassword.getText());
        if (studentLogic.getAuthority(account,password)==1){
            Intent intent=new Intent(ActivityUserLogin.this,ActivityStudentDetail.class);
            intent.putExtra("parentName",studentLogic.getParentName(account,password));
            intent.putExtra("account",account);
            intent.putExtra("password",password);
            startActivity(intent);
        }else if (studentLogic.getAuthority(account,password)==2){
            Intent intent=new Intent(ActivityUserLogin.this,ActivityTeacherPage.class);
            intent.putExtra("teacherName",teacherLogic.getTeacherName(account,password));
            startActivity(intent);
        }else {
            Toast.makeText(this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
        }
    }
}
