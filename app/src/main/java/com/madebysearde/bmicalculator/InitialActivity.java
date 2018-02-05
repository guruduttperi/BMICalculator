package com.madebysearde.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InitialActivity extends AppCompatActivity {

    //Declaring all the UI elements and the variables that are to be used

    Button metricButton, imperialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        metricButton = (Button)findViewById(R.id.metric_btn);
        imperialButton = (Button)findViewById(R.id.imperial_btn);

        metricButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MetricActivity.class);
                startActivity(i);
            }
        });

        imperialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(),ImperialActivity.class);
                startActivity(j);
            }
        });
    }
}
