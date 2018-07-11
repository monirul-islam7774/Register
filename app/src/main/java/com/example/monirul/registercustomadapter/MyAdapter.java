package com.example.monirul.registercustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    String[] name, email;
    Context context;

    public  MyAdapter(Context context, String[] name, String[] email) {
        this.context = context;
        this.name = name;
        this.email = email;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.demo_view, viewGroup, false);
        }

        TextView tv = view.findViewById(R.id.textView1);
        Button btn = view.findViewById(R.id.btnDemo);

        tv.setText(name[i]);

        return view;
    }
}
