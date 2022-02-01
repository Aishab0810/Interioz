package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class house2 extends AppCompatActivity {
    TextView hdt11,hdt12;
    ImageView hdd2;
    Button htb11,htb12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housed1);
        living1();
    }
    void living1()
    {
        hdt11=findViewById(R.id.hdt1);
        hdt12=findViewById(R.id.hdt2);
        hdd2=findViewById(R.id.hdd1);
        htb11=findViewById(R.id.htb11);
        htb12=findViewById(R.id.htb12);

        htb11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(house2.this,Housedecor.class);
                startActivity(intent);
            }
        });

        htb12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(house2.this,Payment.class);
                startActivity(intent);
            }
        });
    }
}