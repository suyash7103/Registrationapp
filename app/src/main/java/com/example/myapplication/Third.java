package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Third extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    FirebaseAuth fa;
    FirebaseDatabase fd;
    DatabaseReference dr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b1=(Button) findViewById(R.id.button5);
        b2=(Button)findViewById(R.id.button6);
        e1=(EditText)findViewById(R.id.editTextTextPersonName8);
        e2=(EditText)findViewById(R.id.editTextTextPersonName9);
        e3=(EditText)findViewById(R.id.editTextTextPersonName10);
        fd=FirebaseDatabase.getInstance();
        fa=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fa.signOut();
                Intent k=new Intent(Third.this,MainActivity.class);
                startActivity(k);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dr= fd.getReference("Users");
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if(s3.length()!=10){
                    Toast.makeText(Third.this, "phone length not correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Users users=new Users(s1,s2,s3);
                    dr.child(s3).setValue(users);
                    Toast.makeText(Third.this, "database stored", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}