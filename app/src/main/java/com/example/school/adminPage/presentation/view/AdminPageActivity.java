package com.example.school.adminPage.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.school.R;


import com.example.school.adminPage.domain.Interactors;
import com.example.school.adminPage.domain.InteractorsImpl;
import com.example.school.adminPage.presentation.IPresenterAdminPage;
import com.example.school.adminPage.presentation.PresenterAdminPage;

import com.example.school.adminPage.data.repository.IRepositoryImpl;
import com.example.school.adminPage.data.repository.RepositoryInterface;
import com.example.school.controller.ActivityTeacherRegister;


import javax.inject.Inject;

/**
 * Created by xiecy on 2017/12/20.
 */

public class AdminPageActivity extends AppCompatActivity implements View.OnClickListener, IPresenterAdminPage.View {

    private EditText edtId;

    private EditText edtName;

    private EditText edtTeacher;

    private Button queryButton;

    private Button updateButton;

    private Button deleteButton;

    private Button QueryByTeacherIdButton;

    private Button insertTeacherButton;

    private ListView listView;

    private AdminAdapter adminAdapter;

    private String message;


    @Inject
    PresenterAdminPage presenterAdminPage;

    Interactors interactors = new InteractorsImpl();
    RepositoryInterface repositoryInterface = new IRepositoryImpl();

    Integer id = Integer.valueOf(String.valueOf(edtId.getText()));
    String name = String.valueOf(edtName.getText());
    Integer teacher = Integer.valueOf(String.valueOf(edtTeacher.getText()));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        initView();

        // DaggerAdminPageComponent.builder().adminPageModule(new AdminPageModule(this)).build().inject(this);
    }


    private void initView() {
        listView = findViewById(R.id.list_view_page);
        queryButton = findViewById(R.id.Query);
        updateButton = findViewById(R.id.Update);
        deleteButton = findViewById(R.id.Delete);
        QueryByTeacherIdButton = findViewById(R.id.QueryByTeacherId);
        insertTeacherButton = findViewById(R.id.Insert);
        edtId = findViewById(R.id.edt_id);
        edtName = findViewById(R.id.edt_name);
        edtTeacher = findViewById(R.id.edt_teacher);
        queryButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        QueryByTeacherIdButton.setOnClickListener(this);
        insertTeacherButton.setOnClickListener(this);
        adminAdapter = new AdminAdapter(this);
        listView.setAdapter(adminAdapter);

        showData();

    }

    private void showData() {
        presenterAdminPage.getData(message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Query:
                showData();
                break;
            case R.id.Update:
                presenterAdminPage.update(id, name, teacher, message);
                showData();
                break;
            case R.id.Delete:
                if (edtId.length() != 0) {
                    int id = Integer.valueOf(String.valueOf(edtId.getText()));
                    presenterAdminPage.delete(id);
                    showData();
                } else {
                    Toast.makeText(this, "请输入删除ID", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.QueryByTeacherId:
                if (edtTeacher.length() != 0) {
                    adminAdapter.setList(presenterAdminPage.queryByTeacherId(id));
                    adminAdapter.notifyDataSetChanged();
                    showData();
                } else {
                    Toast.makeText(this, "请输入查询ID", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.Insert:
                startActivity(new Intent(AdminPageActivity.this, ActivityTeacherRegister.class));
            default:
                break;

        }
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {
        message = "Error!";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showDataInfo() {
        adminAdapter.setList(presenterAdminPage.getDataSuccess());
        adminAdapter.notifyDataSetChanged();
    }
}
