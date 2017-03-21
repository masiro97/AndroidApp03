package com.android.masiro.proj031;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    TextView t1,t2;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("학점계산기");

        b1 = (Button)findViewById(R.id.button11);
        b2 = (Button)findViewById(R.id.button12);
        e1 = (EditText)findViewById(R.id.editText1);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        t1 = (TextView)findViewById(R.id.textView5);
        t2 = (TextView)findViewById(R.id.textView7);
        i = (ImageView)findViewById(R.id.imageView);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int kor = Integer.parseInt(e1.getText().toString());
                int math = Integer.parseInt(e2.getText().toString());
                int eng = Integer.parseInt(e3.getText().toString());
                int total = kor + math + eng;
                double mean = (kor + math + eng) /3;

                t1.setText(total + "점");
                t2.setText(mean + "점");

                i.setVisibility(View.VISIBLE);
                if(mean >= 90) i.setImageResource(R.drawable.a);
                else if(mean >=80) i.setImageResource(R.drawable.b);
                else if(mean >=70) i.setImageResource(R.drawable.c);
                else if(mean >=60) i.setImageResource(R.drawable.d);
                else i.setImageResource(R.drawable.f);

                ///학점 이미지 나오게 하기
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //초기화 시키기
                e1.setText(null);
                e2.setText(null);
                e3.setText(null);

                t1.setText("0점");
                t2.setText("0점");
                i.setVisibility(View.INVISIBLE);

                Toast.makeText(getApplicationContext(),"초기화 되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

    }



}
