package com.naitiks.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Naitik on 9/4/2017.
 */

public class ListAdapter extends BaseAdapter {
    private ArrayList<UserModel> dataList = null;
    private Context context = null;

    public ListAdapter(Context context, ArrayList<UserModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        UserHolder holder = null;
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.row,viewGroup,false);
            holder = new UserHolder();
            holder.firstName = (TextView)view.findViewById(R.id.first_letter);
            holder.name = (TextView)view.findViewById(R.id.name);
            view.setTag(holder);
        }else{
            holder = (UserHolder) view.getTag();
        }
        String name = dataList.get(i).getName();
        holder.firstName.setText(name.substring(0,1).toUpperCase());
        holder.name.setText(name);
        return view;
    }

    class UserHolder{
        TextView firstName, name;
        public UserHolder(){ }
    }
}
