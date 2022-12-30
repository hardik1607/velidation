package com.example.velidation.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.velidation.R;
import com.example.velidation.adapters.view_detail_adapter;

import java.util.ArrayList;

public class view_detail extends AppCompatActivity {

    ListView listView;
    ArrayList id,name,contact,pass;
    MyClass m= new MyClass(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);

        listView=findViewById(R.id.list);

        id=new ArrayList();
        name=new ArrayList();
        contact=new ArrayList();
        pass=new ArrayList();


        Cursor c=m.getdata();

        while (c.moveToNext())
        {
            id.add(c.getInt(0));
            name.add(c.getString(1));
            contact.add(c.getString(2));
            pass.add(c.getString(3));
        }



        view_detail_adapter adapter = new view_detail_adapter(this,id,name,contact,pass);
        listView.setAdapter(adapter);

    }
}