package com.example.school.dao;

import org.litepal.crud.DataSupport;

/**
 * Created by xiecy on 2017/12/12.
 */

public class DialogDetail extends DataSupport{

    private int id;

    private String userName;

    private String dialogName;

    private String dialogContent;

    private DialogTitle dialogTitle;

    public DialogTitle getDialogTitle() {
        return dialogTitle;
    }

    public void setDialogTitle(DialogTitle dialogTitle) {
        this.dialogTitle = dialogTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDialogName() {
        return dialogName;
    }

    public void setDialogName(String dialogName) {
        this.dialogName = dialogName;
    }

    public String getDialogContent() {
        return dialogContent;
    }

    public void setDialogContent(String dialogContent) {
        this.dialogContent = dialogContent;
    }
}
