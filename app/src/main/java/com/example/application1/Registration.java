package com.example.application1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registration extends AppCompatActivity {

    //Create object of DatabaseReference class to access firebase's realtime database
    DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReferenceFromUrl("https://interioz-default-rtdb.firebaseio.com/1");
    EditText r1,r2,r3,r4;
    Button rb2;
    ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        Registration();
    }

    void Registration() {
       final EditText r1=(EditText)findViewById(R.id.r1);
       final EditText r2=(EditText)findViewById(R.id.r2);
       final EditText r3=(EditText)findViewById(R.id.r3);
       final EditText r4=(EditText)findViewById(R.id.r4);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);

//        String name=r1.getText().toString().trim();
//        String email=r2.getText().toString().trim();
//        String password=r3.getText().toString().trim();

        final Button rb2=(Button) findViewById(R.id.rb2);

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String namee=r1.getText().toString();
                final String mail=r2.getText().toString();
                final String pswd=r3.getText().toString();
                final String cnfm=r4.getText().toString();

                //check if user fills all the data before sending it to the firebase
                if(namee.isEmpty() || mail.isEmpty() || pswd.isEmpty() || cnfm.isEmpty()){
                    Toast.makeText(Registration.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                //check if passwords are matching with each other
                //if passwords are not matching then show a toast msg
                else if(!pswd.equals(cnfm)){
                    Toast.makeText(Registration.this,"Passwords are not matching",Toast.LENGTH_SHORT).show();
                }

                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if mail has not registered before
                            if(snapshot.hasChild(mail)) {
                                Toast.makeText(Registration.this,"Mail is already exists",Toast.LENGTH_SHORT).show();
                            }
                        else{
                                //sending data to firebase realtime database
                                //we are using mail as unique id of user
                                //so all the details of the user comes under mail id
                                databaseReference.child("users").child(mail).child("Name").setValue(namee);
                                databaseReference.child("users").child(mail).child("Password").setValue(pswd);

                                Toast.makeText(Registration.this, "You have registered successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
//                if(r1.getText().toString().trim().length()==0){
//                    r1.setError("Username is not entered");
//                    r1.requestFocus();
//                }
//                else if(r2.getText().toString().trim().length()==0){
//                    r2.setError("Email is not entered");
//                    r2.requestFocus();
//                }
//                else if(r3.getText().toString().trim().length()==0){
//                    r3.setError("Password is not entered");
//                    r3.requestFocus();}
//                else {
//                    Intent intent = new Intent(Registration.this, MainActivity.class);
//                    startActivity(intent);
//
//                    Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
//                }
            }
        });
//        if(!validateName() | !validatePassword() | !validateEmail()){
//            return;
//        }

    }

//    private Boolean validateName() {
//        String val = r1.getEditableText().toString();
//
//        if (val.isEmpty()) {
//            r1.setError("Field cannot be empty");
//            return false;
//        }
//        else {
//            r1.setError(null);
//            //  t1.setErrorEnabled(false);
//            return true;
//        }
//    }

    private Boolean validateEmail() {
        String val = r3.getEditableText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            r3.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            r3.setError("Invalid email address");
            return false;
        } else {
            r3.setError(null);
            // t3.setErrorEnabled(false);
            return true;
        }
    }

    String passwordVal = "^" +
            //"(?=.*[0-9])" +         //at least 1 digit
            //"(?=.*[a-z])" +         //at least 1 lower case letter
            //"(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            "(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{4,}" +               //at least 4 characters
            "$";
    private Boolean validatePassword() {
        String val = r2.getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            r2.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            r2.setError("Password is too weak");
            return false;
        } else {
            r2.setError(null);
            //t2.setErrorEnabled(false);
            return true;
        }
  //      progressBar.setVisibility(View.VISIBLE);
//        mAuth.createUserWithEmailAndPassword(r2,r3)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        //need to check if task is completed
//                        if(task.isSuccessful()) {
//                            //we have to create user object in realtime database
//                            User user=new User(r1,r2,r3);
//                                    //now we need to send this data to realtime database
//                            //make sure u have connected realtime database
//                            FirebaseDatabase.getInstance().getReference("Users")
//                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if(task.isSuccessful()){
//                                        Toast.makeText(Registration.this, "User has been registered!!!", Toast.LENGTH_LONG).show();
//                                        progressBar.setVisibility(View.GONE);
//                                    }
//                                }
//                            });
//                        }   else
//                        {
//                            Toast.makeText(Registration.this, "User has been registered!!!", Toast.LENGTH_LONG).show();
//                            progressBar.setVisibility(View.GONE);
//                        }
//                    }
           //     });

    }
}
  
