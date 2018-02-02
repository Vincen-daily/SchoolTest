package com.example.school.logic;

import com.example.school.dao.DialogDetail;
import com.example.school.dao.DialogTitle;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/12/12.
 */

public class DialogLogicImpl implements DialogLogic {

    List<DialogTitle> dialogTitleList = new ArrayList<>();

    List<DialogDetail> dialogDetailList = new ArrayList<>();

    @Override
    public List<DialogTitle> queryDialogTitle() {
        Connector.getDatabase();
        dialogTitleList = DataSupport.findAll(DialogTitle.class);
        return dialogTitleList;
    }

    @Override
    public void addDialogTitle(String dialogName) {
        DialogTitle dialogTitle = new DialogTitle();
        dialogTitle.setDialogName(dialogName);
        dialogTitle.save();
    }

    @Override
    public List<DialogDetail> queryDialogInfo() {
        Connector.getDatabase();
        dialogDetailList = DataSupport.findAll(DialogDetail.class);
        return dialogDetailList;
    }

    @Override
    public void addDialogContent(String parentName, String teacherName, String dialogContent, String dialogName) {
        DialogDetail dialogDetail = new DialogDetail();
        if (parentName != null && teacherName == null) {
            dialogDetail.setUserName(parentName);
        } else {
            dialogDetail.setUserName(teacherName);
        }
        dialogDetail.setDialogContent(dialogContent);
        dialogDetail.setDialogName(dialogName);
        dialogDetail.save();
    }
}
