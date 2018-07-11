package com.example.monirul.registercustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DemoActivity extends AppCompatActivity {

    ListView listView;
    String[] name,email,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        listView = findViewById(R.id.listViewForDemo);
        name = getResources().getStringArray(R.array.person_name);
        email = getResources().getStringArray(R.array.person_email);
        phone = getResources().getStringArray(R.array.person_phone);

        MyAdapter adapter = new MyAdapter(this, name, email);
        listView.setAdapter(adapter);
    }
}
