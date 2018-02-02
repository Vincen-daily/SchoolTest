package com.example.school.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.school.R;
import com.example.school.adminPage.presentation.view.AdminPageActivity;
import com.example.school.logic.TeacherLogic;
import com.example.school.logic.TeacherLogicImpl;

public class ActivityTeacherRegister extends AppCompatActivity implements View.OnClickListener {

    private EditText teacherAccount;

    private EditText teacherPassword;

    private Button insertTeacher;

    private TeacherLogic teacherLogic=new TeacherLogicImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register);

        initView();
    }

    private void initView() {
        teacherAccount=findViewById(R.id.RegisterTeacher_Account);
        teacherPassword=findViewById(R.id.RegisterTeacher_Password);
        insertTeacher=findViewById(R.id.InsertTeacher);
        insertTeacher.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.InsertTeacher:
                insert();
        }
    }

    private void insert() {
        String account=String.valueOf(teacherAccount.getText());
        String password=String.valueOf(teacherPassword.getText());
        teacherLogic.insert(account,password);
        Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ActivityTeacherRegister.this,AdminPageActivity.class));
    }
}
