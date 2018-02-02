package com.example.school.adminPage.presentation.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.school.R;
import com.example.school.adminPage.presentation.model.StudentModel;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/11/28.
 */

public class AdminAdapter extends BaseAdapter {

    private Context context;


    private List<StudentModel> studentList = new ArrayList<>();



    StudentModel studentModel;

    private LayoutInflater inflater;

    public AdminAdapter(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //StudentComponent component= DaggerRepositoryComponent.builder().repositoryModule(new RepositoryModule()).build().inject(this);

    public void setList(List<StudentModel> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();

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

        studentModel = studentList.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_admin_page, null);
            viewHolder.studentIdView = (TextView) convertView.findViewById(R.id.txt_item1_StudentId);
            viewHolder.studentNameView = (TextView) convertView.findViewById(R.id.txt_item1_StudentName);
            //  viewHolder.teacherIdView=(TextView)convertView.findViewById(R.id.txt_item1_TeacherId);
            viewHolder.teacherView = (TextView) convertView.findViewById(R.id.txt_item1_Teacher);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.studentIdView.setText(String.valueOf(studentModel.getId()));
        viewHolder.studentNameView.setText(String.valueOf(studentModel.getStudentName()));
        //  viewHolder.teacherIdView.setText(String.valueOf(student.getTeacherEntity().getId()));
        viewHolder.teacherView.setText(String.valueOf(studentModel.getTeacherModel()));
        return convertView;

    }

    class ViewHolder {
        private TextView studentIdView;
        private TextView studentNameView;
        //   private TextView teacherIdView;
        private TextView teacherView;
    }
}
