package com.example.application1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Payment extends AppCompatActivity implements PaymentResultListener {
    Button btnPay,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btnPay=findViewById(R.id.btnPay);
        home=findViewById(R.id.home);

        //initialize amount
        String sAmount="100";

        //convert and round off
        int amount=Math.round(Float.parseFloat(sAmount)*100);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialize razorpay checkout
                Checkout checkout=new Checkout();
                //set key id
                checkout.setKeyID("rzp_test_3sKQwyPlSMkzeF");
                //set image
                checkout.setImage(R.drawable.rzp_logo);
                //initialize json object
                JSONObject object=new JSONObject();

                try {
                    //put name
                    object.put("name","Aisha");
                    //put description
                    object.put("description","Payment");
                    //put theme color
                    object.put("theme.color","black");
                    //put currency unit
                    object.put("Currency","INR");
                    //put amount
                    object.put("Amount","amount");
                    //put mobile number
                    object.put("prefill.contact","8378882133");
                    //put email
                    object.put("prefill.email","borseaisha98@gmail.com");
                    //open razorpay checkout activity
                    checkout.open(Payment.this,object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Payment.this,hello.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        //initialize alert dialog
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //set title
        builder.setTitle("Payment ID");
        //set message
        builder.setMessage(s);
        //show alert dialog
        builder.show();
    }

    @Override
    public void onPaymentError(int i, String s) {
            //display toast
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }
}