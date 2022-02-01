package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Housedecor extends AppCompatActivity {
TextView hdecor;
ImageView hd1,hd2;
Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housedecor);
        housedecor();
    }
    void housedecor()
    {
        hdecor=findViewById(R.id.hdecor);
        hd1=findViewById(R.id.hd1);
        hd2=findViewById(R.id.hd2);

        btn2=findViewById(R.id.btn2);

        hd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Housedecor.this,housed1.class);
                startActivity(intent);
            }
        });
        hd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Housedecor.this,house2.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Housedecor.this,hello.class);
                startActivity(intent);
            }
        });
    }
}