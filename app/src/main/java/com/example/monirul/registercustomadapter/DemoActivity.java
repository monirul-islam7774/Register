package com.example.monirul.registercustomadapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener{

    ListView listView;
    String[] name,email,phone;
    Button regButton;
    ArrayList<Person> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        regButton = findViewById(R.id.registerButtonId);
        listView = findViewById(R.id.listViewForDemo);
        name = getResources().getStringArray(R.array.person_name);
        email = getResources().getStringArray(R.array.person_email);
        phone = getResources().getStringArray(R.array.person_phone);
        this.contacts = new ArrayList<>();
        //adapter = new ArrayAdapter<>(DemoActivity.this,R.layout.demo_view,R.id.textView1,contacts);

        MyAdapter adapter = new MyAdapter(this, name, email, phone);
        listView.setAdapter(adapter);

        regButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.registerButtonId){

            Intent intent = new Intent(DemoActivity.this,RegisterActivity.class);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){

            String valueName = data.getStringExtra("name");
            String valueEmail = data.getStringExtra("email");
            String valueNumber = data.getStringExtra("number");

            Person person = new Person(valueName, valueEmail, valueNumber);
            contacts.add(person);
            CustomAdapter adapter = new CustomAdapter(DemoActivity.this, contacts);
            listView.setAdapter(adapter);
        }
    }

    class Person {
        String name;
        String email;
        String phone;

        public Person(String valueName, String valueEmail, String valueNumber) {
            this.name = valueName;
            this.email = valueEmail;
            this.phone = valueNumber;
        }
    }

    class CustomAdapter extends BaseAdapter{

        ArrayList<Person> contacts;
        Context context;

        public CustomAdapter(Context context, ArrayList<Person> contacts) {
            this.contacts = contacts;
            this.context = context;
        }

        @Override
        public int getCount() {
            return contacts.size();
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
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.demo_view, viewGroup, false);
            }

            TextView textView = view.findViewById(R.id.textView1);
            Button btnCall = view.findViewById(R.id.btnCall);
            Button btnEmail = view.findViewById(R.id.btnEmail);

            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phone[i]));
                    context.startActivity(intent);
                }
            });

            btnEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto: "+email[i]));
                    context.startActivity(intent);
                }
            });

            textView.setText(contacts.get(i).name);

            return view;
        }
    }
}
