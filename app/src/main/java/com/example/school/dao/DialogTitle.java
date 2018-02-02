package com.example.school.dao;

import android.provider.ContactsContract;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/12/12.
 */

public class DialogTitle extends DataSupport{

    private int id;

    private String dialogName;

    List<DialogDetail>dialogDetailList=new ArrayList<DialogDetail>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDialogName() {
        return dialogName;
    }

    public void setDialogName(String dialogName) {
        this.dialogName = dialogName;
    }

    public List<DialogDetail> getDialogDetailList() {
        return dialogDetailList;
    }

    public void setDialogDetailList(List<DialogDetail> dialogDetailList) {
        this.dialogDetailList = dialogDetailList;
    }
}
