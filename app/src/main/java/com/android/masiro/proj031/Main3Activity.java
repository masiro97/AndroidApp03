package com.android.masiro.proj031;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class Main3Activity extends AppCompatActivity {
    Button b1,b2;
    Switch aSwitch;
    TextView t1;
    Chronometer c;
    DatePicker aPicker;
    TimePicker tPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("레스토랑 예약시스템");

        b1 = (Button)findViewById(R.id.button31);
        b2 = (Button)findViewById(R.id.button32);
        aSwitch = (Switch)findViewById(R.id.switch1);
        t1 = (TextView)findViewById(R.id.textView1);
        c = (Chronometer)findViewById(R.id.chronometer);
        aPicker = (DatePicker)findViewById(R.id.datePicker);
        tPicker = (TimePicker)findViewById(R.id.timePicker);


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true) {
                    t1.setVisibility(View.VISIBLE);
                    c.setVisibility(View.VISIBLE);
                    aPicker.setVisibility(View.VISIBLE);
                    b1.setVisibility(View.VISIBLE);
                    b1.setEnabled(false);
                    b2.setVisibility(View.VISIBLE);
                    c.start();

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            b1.setEnabled(true);
                            int year = aPicker.getYear();
                            int month = aPicker.getMonth();
                            int date = aPicker.getDayOfMonth();

                            aPicker.setVisibility(View.INVISIBLE);
                            tPicker.setVisibility(View.VISIBLE);



                        }
                    });
                }

            }
        });
    }

}
