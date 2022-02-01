package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HotelDecor extends AppCompatActivity {
    TextView hodecor;
    ImageView hod1,hod2;
    Button btn22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_decor);
        housedecor();
    }
    void housedecor()
    {
        hodecor=findViewById(R.id.hodecor);
        hod1=findViewById(R.id.hod1);
        hod2=findViewById(R.id.hod2);

        btn22=findViewById(R.id.btn22);

        hod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HotelDecor.this,hotel1.class);
                startActivity(intent);
            }
        });
        hod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HotelDecor.this,hotel2.class);
                startActivity(intent);
            }
        });

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HotelDecor.this,hello.class);
                startActivity(intent);
            }
        });
    }
}