package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class office2 extends AppCompatActivity {
    TextView odt122,odt112;
    ImageView odd22;
    Button odb11,odb12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office2);
        living1();
    }
    void living1()
    {
        odd22=findViewById(R.id.odd22);
        odt122=findViewById(R.id.odt122);
        odt112=findViewById(R.id.odt112);
        odb11=findViewById(R.id.odb11);
        odb12=findViewById(R.id.odb12);

        odb11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(office2.this,OfficeDecor.class);
                startActivity(intent);
            }
        });

        odb12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(office2.this,Payment.class);
                startActivity(intent);
            }
        });
    }
}