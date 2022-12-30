package com.example.velidation.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.velidation.R;

import java.util.ArrayList;

public class update extends AppCompatActivity {

    Button update;
    EditText ename,econtact,epassword;
    String id,name,contact,pass;
    MyClass m = new MyClass(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        update=findViewById(R.id.update);
        ename=findViewById(R.id.name);
        econtact=findViewById(R.id.contact);
        epassword=findViewById(R.id.password);

        id=getIntent().getStringExtra("id");
        name=getIntent().getStringExtra("name");
        contact=getIntent().getStringExtra("contact");
        pass=getIntent().getStringExtra("pass");

        ename.setText(name);
        econtact.setText(contact);
        epassword.setText(pass);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ename.getText().toString();
                String contact=econtact.getText().toString();
                String password=epassword.getText().toString();

                if (name.isEmpty())
                {
                    ename.setError("Enter Name");
                    ename.requestFocus();
                }
                else if (name.length()<6)
                {
                    ename.setError("Enter name Should Be 6 Digit");
                    ename.requestFocus();
                }
                else if (contact.isEmpty())
                {
                    econtact.setError("Enter Contect");
                    econtact.requestFocus();
                }
                else if (!contact.toString().startsWith("+91"))
                {
                    econtact.setError("Enter Mobail Number With India Contry Code");
                    econtact.requestFocus();
                }
                else if (contact.length()!=13)
                {
                    econtact.setError("Enter Contact Should Be 10 Digit");
                    econtact.requestFocus();
                }
                else if (password.length()<8)
                {
                    epassword.setError("Enter Contact Should Be 8 Digit");
                    epassword.requestFocus();
                }
                else
                {
                    Toast.makeText(update.this, "Data Updated", Toast.LENGTH_SHORT).show();
                    m.dataupdate(id,name,contact,pass);

                    Intent intent = new Intent(update.this,view_detail.class);
                    startActivity(intent);
                }

            }
        });

    }
}