package com.android.masiro.proj031;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main3Activity extends AppCompatActivity {
    Button b1,b2;
    Switch aSwitch;
    TextView t1,t7,t9,t11,t13,t15;
    EditText e1,e2,e3;
    Chronometer c;
    DatePicker aPicker;
    TimePicker tPicker;
    GridLayout gLayout;
    TableLayout tLayout;
    int page = 0;
    String adult = null, kid = null, junior = null;
    int year = 2017,month = 3,date = 19;
    int hour = 1,minute = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("레스토랑 예약시스템");

        b1 = (Button)findViewById(R.id.button31);
        b2 = (Button)findViewById(R.id.button32);
        aSwitch = (Switch)findViewById(R.id.switch1);
        t1 = (TextView)findViewById(R.id.textView1);
        t7 = (TextView)findViewById(R.id.textView7);
        t9 = (TextView)findViewById(R.id.textView9);
        t11 = (TextView)findViewById(R.id.textView11);
        t13 = (TextView)findViewById(R.id.textView13);
        t15 = (TextView)findViewById(R.id.textView15);
        e1 = (EditText)findViewById(R.id.editText1);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        c = (Chronometer)findViewById(R.id.chronometer);
        aPicker = (DatePicker)findViewById(R.id.datePicker);
        tPicker = (TimePicker)findViewById(R.id.timePicker);
        gLayout = (GridLayout)findViewById(R.id.gridlayout);
        tLayout = (TableLayout)findViewById(R.id.tablelayout);



        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true) {
                    page =1;

                    PrintPage(page);

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            page++;
                          PrintPage(page);

                            b1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    page--;
                                    PrintPage(page);

                                }
                            });

                            b2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    page++;
                                    PrintPage(page);

                                    b1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            page--;
                                            PrintPage(page);

                                        }
                                    });

                                    b2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            page++;
                                           PrintPage(page);

                                            b1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    page--;
                                                    PrintPage(page);
                                                }
                                            });
                                        }
                                    });

                                }
                            });

                        }
                    });
                }

            }
        });

    }

    public void PrintPage(int page){

        if(page ==1){
            t1.setVisibility(View.VISIBLE);
            c.setVisibility(View.VISIBLE);
            aPicker.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);
            b1.setEnabled(false);
            b2.setEnabled(true);
            b2.setVisibility(View.VISIBLE);
            tPicker.setVisibility(View.INVISIBLE);
            gLayout.setVisibility(View.INVISIBLE);
            tLayout.setVisibility(View.INVISIBLE);
            c.start();

        }
        else if(page ==2){

            b1.setEnabled(true);
            b2.setEnabled(true);

            aPicker.setVisibility(View.INVISIBLE);
            tPicker.setVisibility(View.VISIBLE);
            gLayout.setVisibility(View.INVISIBLE);
            tLayout.setVisibility(View.INVISIBLE);

            year = aPicker.getYear();
            month = aPicker.getMonth() + 1;
            date = aPicker.getDayOfMonth();


            //Toast.makeText(getApplicationContext(),hour + "시" + minute+"분",Toast.LENGTH_SHORT).show();

        }

        else if(page ==3){
            b1.setEnabled(true);
            b2.setEnabled(true);

            aPicker.setVisibility(View.INVISIBLE);
            tPicker.setVisibility(View.INVISIBLE);
            gLayout.setVisibility(View.VISIBLE);
            tLayout.setVisibility(View.INVISIBLE);

            hour = tPicker.getHour();
            minute = tPicker.getMinute();

        }

        else if(page ==4){
            b1.setEnabled(true);
            b2.setEnabled(false);
            aPicker.setVisibility(View.INVISIBLE);
            tPicker.setVisibility(View.INVISIBLE);
            gLayout.setVisibility(View.INVISIBLE);
            tLayout.setVisibility(View.VISIBLE);

            adult = e1.getText().toString();
            junior = e2.getText().toString();
            kid = e3.getText().toString();

            t7.setText(year + "." + month + "." + date);
            t9.setText(hour + "시" + minute+"분");
            t11.setText(adult + "명");
            t13.setText(junior + "명");
            t15.setText(kid+ "명");
        }
    }

}
