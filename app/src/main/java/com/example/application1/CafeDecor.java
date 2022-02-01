package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CafeDecor extends AppCompatActivity {
    TextView cdecor;
    ImageView cd1,cd2;
    Button btnc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_decor);
        housedecor();
    }
    void housedecor()
    {
        cdecor=findViewById(R.id.cdecor);
        cd1=findViewById(R.id.cd1);
        cd2=findViewById(R.id.cd2);

        btnc2=findViewById(R.id.btnc2);

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CafeDecor.this,cafe1.class);
                startActivity(intent);
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CafeDecor.this,cafe2.class);
                startActivity(intent);
            }
        });

        btnc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CafeDecor.this,hello.class);
                startActivity(intent);
            }
        });
    }
}