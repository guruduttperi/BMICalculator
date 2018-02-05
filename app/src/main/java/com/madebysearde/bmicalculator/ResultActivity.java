package com.madebysearde.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    //Declaring all the UI elements and the variables that are to be used

    float bmi_value;
    ImageView avatar;
    TextView bmi_label, category_label;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        avatar = (ImageView)findViewById(R.id.image_say);
        bmi_label = (TextView)findViewById(R.id.say_label);
        category_label = (TextView)findViewById(R.id.status);

        //Retrieving data from previous screen
        Bundle extras = getIntent().getExtras();

        //Categorizing based on BMI

        if(extras!=null){
            bmi_value = extras.getFloat("BMI");
            if(bmi_value<18.5)
            {   avatar.setImageDrawable(getDrawable(R.drawable.underweight));
                bmi_label.setText("Your BMI is: "+ bmi_value);
                category_label.setText("You are Underweight");
            }

            else if(bmi_value>25.0)
            {   avatar.setImageDrawable(getDrawable(R.drawable.overweight));
                bmi_label.setText("Your BMI is: "+ bmi_value);
                category_label.setText("You are Overweight");
            }

            else {
                avatar.setImageDrawable(getDrawable(R.drawable.fit));
                bmi_label.setText("Your BMI is: "+ bmi_value);
                category_label.setText("You are Fit!");
            }

            //Toast.makeText(ResultActivity.this,"BMI is"+bmi_value,Toast.LENGTH_SHORT).show();
        }
    }
}
