package com.mathesh.gradecalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;

public class GradeCalculate extends AppCompatActivity
{
    EditText mat,sci,comp,ta,eng;
    String maths,science,computer,tamil,english,Grade;
    int mathsmark,sciencemark,computermark,tamilmark,englishmark=0;
    ImageView submit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        mat = findViewById(R.id.maths);
        sci=  findViewById(R.id.science);
        comp= findViewById(R.id.computer);
        ta=   findViewById(R.id.tamil);
        eng=  findViewById(R.id.english);

        submit = findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                maths = mat.getText().toString();
                science = sci.getText().toString();
                computer = comp.getText().toString();
                tamil = ta.getText().toString();
                english = eng.getText().toString();

//                String -> Integer - Integer.parseInt()
//                Integer-> String - .toString();
//                Double.parseDouble()

                mathsmark=Integer.parseInt(maths);
                sciencemark=Integer.parseInt(science);
                computermark=Integer.parseInt(computer);
                tamilmark=Integer.parseInt(tamil);
                englishmark=Integer.parseInt(english);

                Grade=calculateGrade(mathsmark,sciencemark,computermark,tamilmark,englishmark);

                Intent intent = new Intent(GradeCalculate.this,DisplayGrade.class);
                intent.putExtra("grade",Grade);
                startActivity(intent);

                Toast.makeText(GradeCalculate.this,Grade,Toast.LENGTH_SHORT).show();



            }
        });
    }


//  This method is used to calculate grade
    protected String calculateGrade(int a, int b,int c,int d,int e)
    {
        int total = a + b + c + d + e;
        float avg = total/5;
        String grade="";
        if(avg<50)
        {
            grade="E";
        }
        else if(avg>50 && avg<61)
        {
            grade="D";
        }
        else if(avg>60 && avg<71)
        {
            grade="C";
        }
        else if(avg>70 && avg<81)
        {
            grade="B";
        }
        else if(avg>80 && avg<91)
        {
            grade="A";
        }
        else if(avg>90 && avg<101)
        {
            grade="O";
        }
        else
        {
            grade="Please Enter Proper Marks";
        }
        return grade;
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        System.exit(0);
    }
}
