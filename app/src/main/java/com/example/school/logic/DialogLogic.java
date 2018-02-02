package com.example.school.logic;

import com.example.school.dao.DialogDetail;
import com.example.school.dao.DialogTitle;

import java.util.List;

/**
 * Created by xiecy on 2017/12/12.
 */

public interface DialogLogic {

    List<DialogTitle> queryDialogTitle();

    void addDialogTitle(String dialogName);

    List<DialogDetail> queryDialogInfo();

    void addDialogContent(String parentName,String teacherName,String dialogContent,String dialogName);
}
