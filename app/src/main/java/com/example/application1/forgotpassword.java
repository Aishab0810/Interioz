package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class forgotpassword extends AppCompatActivity {
    EditText ft3;
    TextView ft1,ft2,ft4,ft5;
    Button fb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        Forgotpassword();
    }
    void Forgotpassword(){
        ft1 = (TextView) findViewById(R.id.ft1);
        ft2 = (TextView) findViewById(R.id.ft2);
        ft3 = (EditText) findViewById(R.id.ft3);
        ft4 = (TextView) findViewById(R.id.ft4);
        ft5 = (TextView) findViewById(R.id.ft5);
        fb1= (Button) findViewById(R.id.fb1);

        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(forgotpassword.this, Registration.class);
//                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Login link is sent", Toast.LENGTH_SHORT).show();
            }
        });

        ft5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forgotpassword.this, Registration.class);
                startActivity(intent);
            }
        });
    }
}