package com.example.velidation.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.velidation.R;

import java.util.ArrayList;

public class enter_diteil extends AppCompatActivity {

    EditText ename,econtact,epassword;
    Button insert,getdata;
    String id1,name1,contact1,pass1;
    MyClass m = new MyClass(this);
    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_diteil);

        ename=findViewById(R.id.name);
        econtact=findViewById(R.id.contact);
        epassword=findViewById(R.id.password);
        insert=findViewById(R.id.insert);
        getdata=findViewById(R.id.get_data);



        pos=getIntent().getIntExtra("pos",0);

        if (pos==1)
        {
            id1=getIntent().getStringExtra("id");
            name1=getIntent().getStringExtra("name");
            contact1=getIntent().getStringExtra("contact");
            pass1=getIntent().getStringExtra("pass");


            ename.setText(name1);
            econtact.setText(contact1);
            epassword.setText(pass1);
        }
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ename.getText().toString();
                String contact=econtact.getText().toString();
                String password=epassword.getText().toString();
//
//                if (name.isEmpty())
//                {
//                    ename.setError("Enter Name");
//                    ename.requestFocus();
//                }
//                else if (name.length()<6)
//                {
//                    ename.setError("Enter name Should Be 6 Digit");
//                    ename.requestFocus();
//                }
//                else if (contact.isEmpty())
//                {
//                    econtact.setError("Enter Contect");
//                    econtact.requestFocus();
//                }
//                else if (!contact.toString().startsWith("+91"))
//                {
//                    econtact.setError("Enter Mobail Number With India Contry Code");
//                    econtact.requestFocus();
//                }
//                else if (contact.length()!=13)
//                {
//                    econtact.setError("Enter Contact Should Be 10 Digit");
//                    econtact.requestFocus();
//                }
//                else if (password.length()<8)
//                {
//                    epassword.setError("Enter Contact Should Be 8 Digit");
//                    epassword.requestFocus();
//                }
//                else
//                {
                    System.out.println("name="+name);
                    System.out.println("contact="+contact);
                    System.out.println("password="+password);
                    System.out.println("pos="+pos);

                    if(pos==1)
                    {

                        m.dataupdate(id1,name,contact,password);
                        System.out.println("id1"+id1);
                        Intent intent = new Intent(enter_diteil.this,view_detail.class);
                        startActivity(intent);

                    }
                    else
                    {
                        m.insertdata(name,contact,password);
//                        m.dataupdate(up_id,up_name,up_contact,up_pass);


                    }

                }
//            }
        });

        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("id="+id1);
                System.out.println("name="+name1);
                System.out.println("contact="+contact1);
                System.out.println("pass="+pass1);

                Intent intent = new Intent(enter_diteil.this, view_detail.class);
                startActivity(intent);
            }
        });
    }
}