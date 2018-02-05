package com.madebysearde.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImperialActivity extends AppCompatActivity {

    //Declaring all the UI elements and the variables that are to be used

    EditText feet_text, inch_text, pound_text;
    Button calculate_bmi;
    String feet_str, inch_str, pound_str;
    Float height, feet, inch, weight, bmi_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imperial);

        feet_text = (EditText)findViewById(R.id.feet_textbox);
        inch_text = (EditText)findViewById(R.id.inch_textbox);
        pound_text = (EditText)findViewById(R.id.pound_textbox);
        calculate_bmi = (Button)findViewById(R.id.calc_bmi);



            calculate_bmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    feet_str = feet_text.getText().toString();
                    inch_str = inch_text.getText().toString();
                    pound_str = pound_text.getText().toString();

                    if (TextUtils.isEmpty(feet_str))
                    {feet_text.setError("Height Cannot be Empty!"); return;}

                    if (TextUtils.isEmpty(inch_str))
                    {inch_text.setError("Height Cannot be Empty!"); return;}

                    if (TextUtils.isEmpty(pound_str))
                    {pound_text.setError("Weight Cannot be Empty!"); return;}

                    inch = Float.parseFloat(inch_str);
                    feet = Float.parseFloat(feet_str);
                    weight = Float.parseFloat(pound_str);

                    height = (feet*12)+inch;
                    if ((height!=0)&&(weight!=0)&&(height<135)&&(weight<1000)) {
                        bmi_val = (weight / (height * height)) * 703;

                        Intent i = new Intent(ImperialActivity.this, ResultActivity.class);
                        i.putExtra("BMI", bmi_val);
                        startActivity(i);
                    }

                }
            });
        }

    }

