package com.example.school.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.school.R;
import com.example.school.dao.DialogTitle;
import com.example.school.logic.DialogLogic;
import com.example.school.logic.DialogLogicImpl;
import com.example.school.view.DialogAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActivityDialog extends AppCompatActivity implements View.OnClickListener {

    private DialogLogic dialogLogic = new DialogLogicImpl();

    private DialogAdapter dialogAdapter;

    List<DialogTitle> dialogTitleList = new ArrayList<>();

    private Button addDialog;

    private ListView listView;

    private EditText edtDialogName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        addDialog = findViewById(R.id.dialog_add);
        listView = findViewById(R.id.dialog_listView);
        edtDialogName = findViewById(R.id.dialog_edt);
        addDialog.setOnClickListener(this);
        dialogAdapter = new DialogAdapter(this, dialogTitleList);
        listView.setAdapter(dialogAdapter);
        load();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogTitle dialogTitle = dialogTitleList.get(position);
                String teacherName = getIntent().getStringExtra("teacherName");
                String parentName = getIntent().getStringExtra("parentName");
                Intent intent = new Intent(ActivityDialog.this, ActivityDialogInfo.class);
                intent.putExtra("teacherName", teacherName);
                intent.putExtra("parentName", parentName);
                intent.putExtra("dialogName", dialogTitle.getDialogName());
                startActivity(intent);
            }
        });
    }

    private void load() {
        dialogTitleList = dialogLogic.queryDialogTitle();
        dialogAdapter.setList(dialogTitleList);
        dialogAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_add:
                if (edtDialogName.length()!=0) {
                    String dialogName = String.valueOf(edtDialogName.getText());
                    dialogLogic.addDialogTitle(dialogName);
                    load();
                } else {
                    Toast.makeText(this, "请输入话题", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
