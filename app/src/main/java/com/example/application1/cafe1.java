package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class cafe1 extends AppCompatActivity {
    TextView cdt11,cdt12;
    ImageView cdd2;
    Button cdb11,cdb12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe1);
        living1();
    }
    void living1()
    {
        cdt11=findViewById(R.id.cdt11);
        cdt12=findViewById(R.id.cdt12);
        cdd2=findViewById(R.id.cdd2);
        cdb11=findViewById(R.id.cdb11);
        cdb12=findViewById(R.id.cdb12);

        cdb11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(cafe1.this,CafeDecor.class);
                startActivity(intent);
            }
        });

        cdb12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(cafe1.this,Payment.class);
                startActivity(intent);
            }
        });
    }
}