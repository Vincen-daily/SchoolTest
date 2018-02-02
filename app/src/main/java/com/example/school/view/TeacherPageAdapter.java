package com.example.school.view;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.school.R;
import com.example.school.dao.Student;
import java.util.ArrayList;
import java.util.List;


public class TeacherPageAdapter extends BaseAdapter {

    List<Student> studentList=new ArrayList<>();

    LayoutInflater layoutInflater;

    private Context context;

    public TeacherPageAdapter(Context context){
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }
    public void setList(List<Student> studentList) {
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
        Student student = studentList.get(position);
        ViewHolder viewHolder ;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.list_item_teacher_page, null);
            viewHolder.studentIdView=(TextView)convertView.findViewById(R.id.teacherPage_tv_StudentId);
            viewHolder.studentNameView = (TextView) convertView.findViewById(R.id.teacherPage_tv_StudentName);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.studentIdView.setText(String.valueOf(student.getId()));
        viewHolder.studentNameView.setText(String.valueOf(student.getStudentName()));
        return convertView;
    }
    class ViewHolder{

        private TextView studentIdView;
        private TextView studentNameView;

    }
}
