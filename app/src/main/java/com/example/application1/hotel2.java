package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class hotel2 extends AppCompatActivity {
    TextView ho12,ho13;
    ImageView ho11;
    Button hob11,hob12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel2);
        living1();
    }
    void living1()
    {
        ho11=findViewById(R.id.ho11);
        ho12=findViewById(R.id.ho12);
        ho13=findViewById(R.id.ho13);
        hob11=findViewById(R.id.hob11);
        hob12=findViewById(R.id.hob12);

        hob11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hotel2.this,HotelDecor.class);
                startActivity(intent);
            }
        });

        hob12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hotel2.this,Payment.class);
                startActivity(intent);
            }
        });
    }
}