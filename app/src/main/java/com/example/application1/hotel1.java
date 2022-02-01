package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class hotel1 extends AppCompatActivity {
    TextView ho2,ho3;
    ImageView ho1;
    Button hob1,hob2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel1);
        living1();
    }
    void living1()
    {
        ho1=findViewById(R.id.ho1);
        ho2=findViewById(R.id.ho2);
        ho3=findViewById(R.id.ho3);
        hob1=findViewById(R.id.hob1);
        hob2=findViewById(R.id.hob2);

        hob1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hotel1.this,Housedecor.class);
                startActivity(intent);
            }
        });

        hob2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hotel1.this,Payment.class);
                startActivity(intent);
            }
        });
    }
}