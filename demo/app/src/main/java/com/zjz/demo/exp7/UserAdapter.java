package com.zjz.demo.exp7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zjz.demo.R;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private int id;
    public UserAdapter(Context context, int textViewId, List<User> obj) {
        super(context, textViewId, obj);
        id = textViewId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User usr = (User) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(id, null);
        TextView Name , Number, Email;
        Name = (TextView) view.findViewById(R.id.usrname);
        Number = (TextView) view.findViewById(R.id.number);
        Email = (TextView) view.findViewById(R.id.email2);
        Name.setText(usr.getName());//为文本视图设置文本内容
        Number.setText(usr.getNumber());//为文本视图设置文本内容
        Email.setText(usr.getEmail());//为文本视图设置文本内容
        return view;
    }

}
