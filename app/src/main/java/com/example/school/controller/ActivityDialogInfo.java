package com.example.school.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.school.R;
import com.example.school.dao.DialogDetail;
import com.example.school.logic.DialogLogic;
import com.example.school.logic.DialogLogicImpl;
import com.example.school.view.DialogInfoAdapter;

import java.util.List;

public class ActivityDialogInfo extends AppCompatActivity implements View.OnClickListener {

    private DialogInfoAdapter dialogInfoAdapter;

    private Button send;

    private EditText edtContent;

    private ListView listView;

    List<DialogDetail> dialogDetailList;

    private DialogLogic dialogLogic = new DialogLogicImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_info);
        initView();
    }

    private void initView() {
        send = findViewById(R.id.dialogInfo_send);
        edtContent = findViewById(R.id.dialogInfo_edt);
        listView = findViewById(R.id.dialogInfo_listView);
        send.setOnClickListener(this);
        dialogInfoAdapter = new DialogInfoAdapter(this, dialogDetailList);
        listView.setAdapter(dialogInfoAdapter);
        load();

    }

    private void load() {
        dialogDetailList = dialogLogic.queryDialogInfo();
        dialogInfoAdapter.setList(dialogDetailList);
        dialogInfoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialogInfo_send:
                String parentName = getIntent().getStringExtra("parentName");
                String teacherName = getIntent().getStringExtra("teacherName");
                String dialogName = getIntent().getStringExtra("dialogName");
                String dialogContent = String.valueOf(edtContent.getText());
                dialogLogic.addDialogContent(parentName, teacherName, dialogContent, dialogName);
                load();
                break;
        }
    }
}
