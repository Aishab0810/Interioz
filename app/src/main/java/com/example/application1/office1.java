package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class office1 extends AppCompatActivity {
    TextView odt11,odt12;
    ImageView odd2;
    Button odb1,odb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office1);
        living1();
    }
    void living1()
    {
        odt11=findViewById(R.id.odt11);
        odt12=findViewById(R.id.odt12);
        odd2=findViewById(R.id.odd2);
        odb1=findViewById(R.id.odb1);
        odb2=findViewById(R.id.odb2);

        odb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(office1.this,OfficeDecor.class);
                startActivity(intent);
            }
        });

        odb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(office1.this,Payment.class);
                startActivity(intent);
            }
        });
    }
}