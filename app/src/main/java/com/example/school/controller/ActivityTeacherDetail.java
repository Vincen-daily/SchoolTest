package com.example.school.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.school.R;
import com.example.school.dao.Student;
import com.example.school.logic.StudentLogic;
import com.example.school.logic.StudentLogicImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/12/06.
 */

public class ActivityTeacherDetail extends AppCompatActivity implements View.OnClickListener {

    private List<Student> studentList = new ArrayList<>();

    private StudentLogic studentLogic=new StudentLogicImpl();

    private Button update;

    private Button comment;

    private EditText edtActivity;

    private TextView textViewId;

    private TextView textViewName;

    private TextView textViewAge;

    private TextView textViewActivity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detail);
        initView();
    }

    private void initView() {
        update = findViewById(R.id.teacher_detail_update);
        comment = findViewById(R.id.teacher_detail_comment);
        edtActivity = findViewById(R.id.teacher_detail_activity);
        textViewId=findViewById(R.id.teacher_detail_tv_id);
        textViewName=findViewById(R.id.teacher_detail_tv_name);
        textViewAge=findViewById(R.id.teacher_detail_tv_age);
        textViewActivity=findViewById(R.id.teacher_detail_tv_activity);
        update.setOnClickListener(this);
        comment.setOnClickListener(this);
        displayDetail();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.teacher_detail_update:
                update();
                break;
            case R.id.teacher_detail_comment:
                String teacherName = getIntent().getStringExtra("teacherName");
                Intent intent = new Intent(ActivityTeacherDetail.this, ActivityDialog.class);
                intent.putExtra("teacherName", teacherName);
                startActivity(intent);
                break;
        }
    }

    public void displayDetail() {
        String studentId = getIntent().getStringExtra("studentId");
        int id = Integer.parseInt(studentId);
        String studentName=studentLogic.queryStudentName(id);
        String studentAge=studentLogic.queryStudentAge(id);
        String studentActivity=studentLogic.queryStudentActivity(id);
        textViewId.setText(String.valueOf(id));
        textViewName.setText(studentName);
        textViewAge.setText(studentAge);
        textViewActivity.setText(studentActivity);

    }

    public void update() {
        String studentId = getIntent().getStringExtra("studentId");
        int id = Integer.parseInt(studentId);
        if (edtActivity.length() == 0) {
            Toast.makeText(this, "请输入修改信息", Toast.LENGTH_SHORT).show();
        } else {
            String activity = String.valueOf(edtActivity.getText());
            studentLogic.updateById(id, activity);
            displayDetail();
        }
    }
}
