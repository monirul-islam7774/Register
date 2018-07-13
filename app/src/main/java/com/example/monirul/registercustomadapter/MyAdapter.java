package com.example.monirul.registercustomadapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MyAdapter extends BaseAdapter{

    String[] name, email, phone;
    Context context;

    public MyAdapter(Context context, String[] name, String[] email, String[] phone) {
        this.context = context;
        this.name = name;
        this.email = email;
        this.phone = phone;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.demo_view, viewGroup, false);
        }

        TextView tv = view.findViewById(R.id.textView1);
        Button btnCall = view.findViewById(R.id.btnCall);
        Button btnEmail = view.findViewById(R.id.btnEmail);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phone[i]));
                context.startActivity(intent);

            }
        });

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto: "+email[i]));
               context.startActivity(intent);
            }
        });

        tv.setText(name[i]);

        return view;
    }


}
