package com.mathesh.gradecalc;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayGrade extends AppCompatActivity
{
    TextView grade;
    String g;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        g=getIntent().getStringExtra("grade");
        grade=findViewById(R.id.grade);
        grade.setText("Your Grade is "+g);
    }
}
