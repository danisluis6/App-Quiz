package com.example.enclaveit.appquiz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.enclaveit.appquiz.R;
import com.example.enclaveit.appquiz.bean.Exam;

import java.util.ArrayList;

/**
 * Created by vuongluis on 1/22/17.
 */

public class ExamAdapter extends ArrayAdapter<Exam> {

    private Context context;
    private int layoutResourceId;
    private ArrayList<Exam> list = new ArrayList<>();

    // You need to specify that you transfer: MainActivity and Data
    public ExamAdapter(Context context, ArrayList<Exam> list){
        super(context,0,list);
        this.context = context;
        this.layoutResourceId = 0;
        this.list = list;
    }
    // Intialzie object to get view
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_quizes_html,parent,false);
        }

        LinearLayout imgQuestion = (LinearLayout) convertView.findViewById(R.id.question);
        TextView textQuestion = (TextView) convertView.findViewById(R.id.question_text);

        Exam exam = getItem(position);
        if(exam!=null){
            textQuestion.setText(String.valueOf(exam.getName()));
        }
        return convertView;
    }
}
