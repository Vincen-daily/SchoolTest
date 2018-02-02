package com.example.school.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.school.R;
import com.example.school.dao.Student;
import com.example.school.logic.StudentLogic;
import com.example.school.logic.StudentLogicImpl;
import com.example.school.view.TeacherPageAdapter;

import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class ActivityTeacherPage extends AppCompatActivity {

    private TeacherPageAdapter teacherPageAdapter;

    List<Student> studentList = new ArrayList<>();

    StudentLogic studentLogic = new StudentLogicImpl();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_page);
        initView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = studentList.get(position);
                String teacherName = getIntent().getStringExtra("teacherName");
                Intent intent = new Intent(ActivityTeacherPage.this, ActivityTeacherDetail.class);
                intent.putExtra("teacherName", teacherName);
                intent.putExtra("studentId", student.getId() + "");//int不能直接传值，要转换
                startActivity(intent);
            }
        });
    }

    private void initView() {
        Connector.getDatabase();
        listView = findViewById(R.id.list_view_teacherPage);
        teacherPageAdapter = new TeacherPageAdapter(this);
        listView.setAdapter(teacherPageAdapter);
        load();
    }

    private void load() {
        studentList = studentLogic.queryAll();
        teacherPageAdapter.setList(studentList);
        teacherPageAdapter.notifyDataSetChanged();
    }
}
