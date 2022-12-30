package com.example.velidation.adapters;

import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.velidation.R;
import com.example.velidation.activitys.MyClass;
import com.example.velidation.activitys.enter_diteil;
import com.example.velidation.activitys.update;
import com.example.velidation.activitys.view_detail;

import java.util.ArrayList;

public class view_detail_adapter extends BaseAdapter {

    com.example.velidation.activitys.view_detail view_detail;
    ArrayList id;
    ArrayList name;
    ArrayList contact;
    ArrayList pass;
    MyClass m;
    public view_detail_adapter(view_detail view_detail,ArrayList id, ArrayList name, ArrayList contact, ArrayList pass) {
        this.view_detail=view_detail;
        this.id=id;
        this.name=name;
        this.contact=contact;
        this.pass=pass;
        m= new MyClass(view_detail);
    }


    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(view_detail).inflate(R.layout.view_detail_item,viewGroup,false);

        TextView t1=view.findViewById(R.id.t1);
        TextView t2=view.findViewById(R.id.t2);
        TextView t3=view.findViewById(R.id.t3);
        TextView t4=view.findViewById(R.id.t4);

        t1.setText(id.get(i).toString());
        t2.setText(name.get(i).toString());
        t3.setText(contact.get(i).toString());
        t4.setText(pass.get(i).toString());


        ImageView delete=view.findViewById(R.id.delete);
        ImageView update=view.findViewById(R.id.upadate);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view_detail, "Data Deleted", Toast.LENGTH_SHORT).show();
                m.datadelete(id.get(i).toString());
                Intent intent = new Intent(view_detail, view_detail.class);
                view_detail.startActivity(intent);
                view_detail.finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=1;
//                Intent intent = new Intent(view_detail, e.class);
                Intent intent = new Intent(view_detail, enter_diteil.class);
                intent.putExtra("pos",pos);
                intent.putExtra("id",id.get(i).toString());
                intent.putExtra("name",name.get(i).toString());
                intent.putExtra("contact",contact.get(i).toString());
                intent.putExtra("pass",pass.get(i).toString());
                view_detail.startActivity(intent);
            }
        });
        return view;
    }
}
