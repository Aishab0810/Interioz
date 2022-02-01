package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class cafe2 extends AppCompatActivity {
    TextView cdt112,cdt122;
    ImageView cdd22;
    Button cdb112,cdb121;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe2);
        living1();
    }
    void living1()
    {
        cdt112=findViewById(R.id.cdt112);
        cdt122=findViewById(R.id.cdt122);
        cdd22=findViewById(R.id.cdd22);
        cdb112=findViewById(R.id.cdb112);
        cdb121=findViewById(R.id.cdb121);

        cdb112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(cafe2.this,CafeDecor.class);
                startActivity(intent);
            }
        });

        cdb121.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(cafe2.this,Payment.class);
                startActivity(intent);
            }
        });
    }
}