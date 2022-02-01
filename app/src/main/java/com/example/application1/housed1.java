package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class housed1 extends AppCompatActivity {
    TextView hdt1,hdt2;
    ImageView hdd1;
    Button htb1,htb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housed1);
        living1();
    }
    void living1()
    {
        hdt1=findViewById(R.id.hdt1);
        hdt2=findViewById(R.id.hdt2);
        hdd1=findViewById(R.id.hdd1);
        htb1=findViewById(R.id.htb1);
        htb2=findViewById(R.id.htb2);

        htb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(housed1.this,Housedecor.class);
                startActivity(intent);
            }
        });

        htb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(housed1.this,Payment.class);
                startActivity(intent);
            }
        });
    }
}