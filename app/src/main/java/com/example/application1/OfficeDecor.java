package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OfficeDecor extends AppCompatActivity {
    TextView odecor;
    ImageView od1,od2;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_decor);
        housedecor();
    }
    void housedecor()
    {
        odecor=findViewById(R.id.odecor);
        od1=findViewById(R.id.od1);
        od2=findViewById(R.id.od2);

        btn2=findViewById(R.id.btn2);

        od1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OfficeDecor.this,office1.class);
                startActivity(intent);
            }
        });
        od2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OfficeDecor.this,office2.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OfficeDecor.this,hello.class);
                startActivity(intent);
            }
        });
    }
}