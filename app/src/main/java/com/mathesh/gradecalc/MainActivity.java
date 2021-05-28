package com.mathesh.gradecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText username,userpass;
    Button submit;
    String name,pass;
    TextView link;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username= findViewById(R.id.username);
        userpass= findViewById(R.id.password);

        submit = findViewById(R.id.button);

        link=findViewById(R.id.link);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                name= username.getText().toString();
                pass= userpass.getText().toString();
//                Removing Extra Spaces
                name = name.replaceAll("\\s", "");
                pass = pass.replaceAll("\\s", "");

                if(name.equals("Mathesh") && pass.equals("Quasar"))
                {
                    Toast.makeText(MainActivity.this,"Correct Login Credentials",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,GradeCalculate.class);
                    startActivity(intent);
                    finish();
                }

                else
                {
                    Toast.makeText(MainActivity.this,"Not Correct Login Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
//                Intent -> An intent is to perform an action on the screen. It is mostly used to start activity, send broadcast receiver,start services and send message between two activities
                Intent intent = new Intent(MainActivity.this,WebActivity.class);
                startActivity(intent);
            }
        });
    }

}