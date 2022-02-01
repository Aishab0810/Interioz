package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class hello extends AppCompatActivity {
    TextView welcome,house,office,hotel,cafe;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        h1();
    }
    void h1()
    {
        welcome=(TextView) findViewById(R.id.welcome);
        house=(TextView) findViewById(R.id.house);
        office=(TextView) findViewById(R.id.office);
        hotel=(TextView) findViewById(R.id.hotel);
        cafe=(TextView) findViewById(R.id.cafe);

        btn1=(Button) findViewById(R.id.btn1);

        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hello.this,Housedecor.class);
                startActivity(intent);
                Toast.makeText(hello.this, "House Interior", Toast.LENGTH_SHORT).show();
            }
        });

        office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hello.this,OfficeDecor.class);
                startActivity(intent);
                Toast.makeText(hello.this, "Office Interior ", Toast.LENGTH_SHORT).show();
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hello.this,HotelDecor.class);
                startActivity(intent);
                Toast.makeText(hello.this, "Hotel Interior ", Toast.LENGTH_SHORT).show();
            }
        });

        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hello.this,CafeDecor.class);
                startActivity(intent);
                Toast.makeText(hello.this, "Cafe Interior ", Toast.LENGTH_SHORT).show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hello.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}