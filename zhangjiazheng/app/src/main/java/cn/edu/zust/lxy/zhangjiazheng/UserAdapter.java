package cn.edu.zust.lxy.zhangjiazheng;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cn.edu.zust.lxy.zhangjiazheng.R;


public class UserAdapter extends ArrayAdapter<User> {
    private int resourceId;
    public UserAdapter(Context context, int resource, List<User> obj) {
        super(context, resource, obj);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position); //获取当前User实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                false);
        TextView userType = (TextView)view.findViewById(R.id.tv_item_type);
        TextView userName = (TextView)view.findViewById(R.id.tv_item_username);
        TextView userPassword = (TextView)view.findViewById(R.id.tv_item_password);

        userType.setText(user.getType());
        userName.setText(user.getName());
        userPassword.setText(user.getPassword());
        return view;
    }
}
