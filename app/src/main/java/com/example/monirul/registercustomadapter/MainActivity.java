package com.example.monirul.registercustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] name,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = getResources().getStringArray(R.array.person_name);
        email = getResources().getStringArray(R.array.person_email);
        phone = getResources().getStringArray(R.array.person_phone);

        listView = findViewById(R.id.listViewId);
        CustomAdapter adapter = new CustomAdapter(this,name,email,phone);
        listView.setAdapter(adapter);

    }
}
