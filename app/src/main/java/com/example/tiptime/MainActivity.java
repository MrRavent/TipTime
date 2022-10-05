package com.example.tiptime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Double cost;

    TextView tip_result;
    EditText cost_of_service;
    RadioGroup tip_options;
    RadioButton twenty_percent, eighteen_percent, fifteen_percent;
    Switch roundup_switch;
    Button calculate_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cost_of_service = findViewById(R.id.cost_of_service);
        tip_options = findViewById(R.id.tip_options);
        roundup_switch = findViewById(R.id.round_up_switch);
        tip_result = findViewById(R.id.tip_result);
        twenty_percent = findViewById(R.id.option_twenty_percent);
        eighteen_percent = findViewById(R.id.option_eighteen_percent);
        fifteen_percent = findViewById(R.id.option_fifteen_percent);
        calculate_button = findViewById(R.id.calculate_button);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cost = Double.valueOf(cost_of_service.getText().toString());

                if (twenty_percent.isChecked()){
                    cost = cost*.20;
                    if (roundup_switch.isChecked()){
                        cost = Math.round(cost *100.0) / 100.0;
                        tip_result.setText("$" + cost.toString());
                    }
                    else {
                        cost = cost *100.0 / 100.0;
                        tip_result.setText("$" + cost.toString());
                    }
                }
                else if(eighteen_percent.isChecked()){
                    cost = cost * .13;
                    if (roundup_switch.isChecked()){
                        cost = Math.round(cost *100.0) / 100.0;
                        tip_result.setText("$" + cost.toString());
                    }
                    else {
                        cost = cost *100.0 / 100.0;
                        tip_result.setText("$" + cost.toString());
                    }
                }
                else if (fifteen_percent.isChecked()){
                    cost = cost * .15;
                    if (roundup_switch.isChecked()){
                        cost = Math.round(cost *100.0) / 100.0;
                        tip_result.setText("$" + cost.toString());
                    }
                    else {
                        cost = cost *100.0 / 100.0;
                        tip_result.setText("$" + cost.toString());
                    }
                }
            }
        });
    }
}