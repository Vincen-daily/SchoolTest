package com.example.school.controller;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.school.R;
import com.example.school.dao.Student;
import com.example.school.logic.StudentLogic;
import com.example.school.logic.StudentLogicImpl;
import java.util.ArrayList;
import java.util.List;

public class ActivityStudentDetail extends AppCompatActivity implements View.OnClickListener {

    private List<Student> studentList = new ArrayList<>();

    private StudentLogic studentLogic=new StudentLogicImpl();

    private Button dialog;

    private TextView textViewId;

    private TextView textViewName;

    private TextView textViewAge;

    private TextView textViewActivity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.student_detail_comment:
                Intent intent = new Intent(ActivityStudentDetail.this, ActivityDialog.class);
                String name = getIntent().getStringExtra("parentName");
                intent.putExtra("parentName", name);
                startActivity(intent);
                break;
        }
    }

    private void initView() {
        textViewId=findViewById(R.id.student_detail_tv_id);
        textViewName=findViewById(R.id.student_detail_tv_name);
        textViewAge=findViewById(R.id.student_detail_tv_age);
        textViewActivity=findViewById(R.id.student_detail_tv_activity);
        dialog = findViewById(R.id.student_detail_comment);
        dialog.setOnClickListener(this);
        displayDetail();
    }

    public void displayDetail() {
        String account = getIntent().getStringExtra("account");
        String password = getIntent().getStringExtra("password");
        int studentId=studentLogic.queryId(account,password);
        String studentName=studentLogic.queryStudentName(studentId);
        String studentAge=studentLogic.queryStudentAge(studentId);
        String studentActivity=studentLogic.queryStudentActivity(studentId);
        textViewId.setText(String.valueOf(studentId));
        textViewName.setText(studentName);
        textViewAge.setText(studentAge);
        textViewActivity.setText(studentActivity);
    }

}
