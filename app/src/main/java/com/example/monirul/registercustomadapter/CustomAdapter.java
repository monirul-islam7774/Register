package com.example.monirul.registercustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    String[] name,email,phone;
    Context context;
    private LayoutInflater inflater;

    CustomAdapter(Context context, String[] name, String[] email, String[] phone){

        this.context = context;
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

    @Override
    public int getCount() {
        return 0;
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
        if (view == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.sample_view,viewGroup,false);
        }

        TextView textView = view.findViewById(R.id.nameId);
        Button callButton = view.findViewById(R.id.callId);
        Button emailButton = view.findViewById(R.id.emailId);

        textView.setText(name[i]);
        callButton.setText(email[i]);
        emailButton.setText(phone[i]);

        return view;
    }

}
