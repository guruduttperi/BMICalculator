package com.madebysearde.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MetricActivity extends AppCompatActivity {

    //Declaring all the UI elements and the variables that are to be used

    EditText height_text, weight_text;
    Button calc_bmi;
    String height_str, weight_str;
    float height, weight;
    float bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metric);

        height_text = (EditText)findViewById(R.id.height_textbox);
        weight_text = (EditText)findViewById(R.id.weight_textbox);

        calc_bmi = (Button)findViewById(R.id.calc_btn);

        calc_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             height_str = height_text.getText().toString();
             weight_str = weight_text.getText().toString();

             if (TextUtils.isEmpty(height_str))
                {height_text.setError("Height Cannot be Empty!"); return;}

             if (TextUtils.isEmpty(weight_str))
             {weight_text.setError("Weight Cannot be Empty!"); return;}

             height = Float.parseFloat(height_str);

             weight = Float.parseFloat(weight_str);

             height/=100;

             if((height!=0)&&(weight!=0)&&(height<250)&&(weight<635)) {
                 bmi = (weight) / (height * height);
                 Intent i = new Intent(MetricActivity.this, ResultActivity.class);
                 i.putExtra("BMI", bmi);
                 startActivity(i);
             }
             else Toast.makeText(getApplicationContext(),"Invalid Data. These values are not possible for a human being",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
