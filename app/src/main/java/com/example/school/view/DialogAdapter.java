package com.example.school.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.school.R;
import com.example.school.dao.DialogTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/12/12.
 */

public class DialogAdapter extends BaseAdapter {

    private List<DialogTitle> dialogTitleList =new ArrayList<>() ;

    private Context context;

    private LayoutInflater inflater;

    public DialogAdapter(Context context, List<DialogTitle> dialogTitleList){
        this.context=context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setList(List<DialogTitle> dialogTitleList) {
        this.dialogTitleList = dialogTitleList;
    }
    @Override
    public int getCount() {
        return dialogTitleList.size();
    }

    @Override
    public Object getItem(int position) {
        return dialogTitleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DialogTitle dialogTitle = dialogTitleList.get(position);
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.list_item_dialog,null);
            viewHolder.dialogNameView=(TextView) convertView.findViewById(R.id.dialog_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.dialogNameView.setText(String.valueOf(dialogTitle.getDialogName()));
        return convertView;
    }
    class ViewHolder{
        private TextView dialogNameView;
    }
}
