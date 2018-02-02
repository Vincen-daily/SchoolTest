package com.example.school.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.school.R;
import com.example.school.dao.DialogDetail;
import com.example.school.dao.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/12/12.
 */

public class DialogInfoAdapter extends BaseAdapter {

    List<DialogDetail>dialogDetailList=new ArrayList<>();

    private Context context;

    private LayoutInflater inflater;

    public DialogInfoAdapter(Context context,List<DialogDetail>dialogDetailList){
        this.context=context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setList(List<DialogDetail> dialogDetailList) {
        this.dialogDetailList = dialogDetailList;
    }
    @Override
    public int getCount() {
        return dialogDetailList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DialogDetail dialogDetail=dialogDetailList.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_dialog_info, null);
            viewHolder.dialogView = (TextView) convertView.findViewById(R.id.dialog_info_dialog_tv);
            viewHolder.userView = (TextView) convertView.findViewById(R.id.dialog_info_user_tv);
            viewHolder.contentView = (TextView) convertView.findViewById(R.id.dialog_info_content_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.dialogView.setText(String.valueOf(dialogDetail.getDialogName()));
        viewHolder.userView.setText(String.valueOf(dialogDetail.getUserName()));
        viewHolder.contentView.setText(String.valueOf(dialogDetail.getDialogContent()));
        return convertView;
    }
    class ViewHolder {
        private TextView dialogView;
        private TextView userView;
        private TextView contentView;
    }
}
