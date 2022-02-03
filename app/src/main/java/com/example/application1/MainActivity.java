package com.example.application1;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    //Create object of DatabaseReference class to access firebase's realtime database
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://interioz-default-rtdb.firebaseio.com/1");
//initialize the variables
    EditText t1, t2, t3;
    Button b1;
    TextView t4,t5;
    ProgressBar progressBar;

    //boolean isEmailValid, isPasswordValid;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login();
        FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
            if(mFirebaseUser != null) {
               String currentUserId = mFirebaseUser.getUid(); //Do what you need to do with the id
          }
    }

    void Login() {
        //assign the values to variables
       final EditText t1 = (EditText) findViewById(R.id.t1);
       final EditText t2 = (EditText) findViewById(R.id.t2);
       final EditText t3 = (EditText) findViewById(R.id.t3);
       final TextView t4 = (TextView) findViewById(R.id.t4);
       final TextView t5 = (TextView) findViewById(R.id.t5);

        b1 = (Button) findViewById(R.id.b1);

        progressBar=(ProgressBar) findViewById(R.id.progressbar);

//        if (mAuth.getCurrentUser() != null) {
//            // User is logged in
//            startActivity(new Intent(MainActivity.this, hello.class));
//            finish();
//        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!t1.getText().toString().isEmpty()) {
//                    if (t1.getText().toString().length() >= 0) {
//                        int index = t1.getText().toString().indexOf(" ");
//                        t1.setText(String.valueOf(index));
//                    }
//                } else {
//                    t1.setError("Plz enter name");
//                }

                final String name=t1.getText().toString();
                final String password=t2.getText().toString();
                final String email=t3.getText().toString();

                if(name.isEmpty() || password.isEmpty() || email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your details", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if mail is exists in firebase database
                            if(snapshot.hasChild(email)){
                                //mail exist in firebase database
                                //now get password of user from firebase data and match it with user entered password
                                final String getPassword=snapshot.child(email).child("Password").getValue(String.class);
                                if(getPassword.equals(password)){
                                Toast.makeText(MainActivity.this,"Successfully Logged in",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this,hello.class));
                                finish();
                                }
                                else {
                                    Toast.makeText(MainActivity.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(MainActivity.this,"User does not exists",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(MainActivity.this,"Something went wrong"+error.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });

                }
//                if(!t1.getText().toString().isEmpty()){
//                    (t1.getText().toString().trim().length()==0)
//                    t1.setError("Username is not entered");
////                    if(!Patterns.EMAIL_ADDRESS.matcher((CharSequence) t1).matches()){
////                        t1.setError("Please provide valid email");
////                        return;
//                    }
//                    t1.requestFocus();
//                }

//                if(t2.getText().toString().trim().length()==0){
//                    t2.setError("Password is not entered");
//                    t2.requestFocus();
//                }
//                if(!t2.getText().toString().isEmpty()) {
//                    if (t2.getText().toString().length() >= 0) {
//                        int index = t2.getText().toString().indexOf("sai");
//                        t2.setText(String.valueOf(index));
//                    }
//                } else {
//                    t2.setError("Plz enter password");
//                }
//
////                if(t3.getText().toString().trim().length()==0){
////                    t3.setError("Email is not entered");
////                    t3.requestFocus();}
//                if(!t3.getText().toString().isEmpty()) {
//                    if (t3.getText().toString().length() >= 0) {
//                        int index = t3.getText().toString().indexOf("sai");
//                        t3.setText(String.valueOf(index));
//                    }
//                } else {
//                    t3.setError("Plz enter password");
//                }

//                {
//                    Intent intent=new Intent(getApplicationContext(), hello.class);
//                    startActivity(intent);
//                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//            }
           }

        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, forgotpassword.class);
                startActivity(intent);
            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Registration.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//        FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
//        if(mFirebaseUser == null) {
//           String currentUser = mFirebaseUser.getUid(); //Do what you need to do with the id
//        }

    }

//    private void updateUI(FirebaseUser currentUser) {
//    }



    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Object mBinding = null;
                            //Snackbar.make(mBinding.mainLayout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }

                    private void updateUI(FirebaseUser user) {
                    }
                });
    }
    //FirebaseAuth.getInstance().signOut();

    private Boolean validateName() {
        String val = t1.getEditableText().toString();

        if (val.isEmpty()) {
            t1.setError("Field cannot be empty");
            return false;
        }
        else {
            t1.setError(null);
          //  t1.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateUsername() {
        String val = t1.getEditableText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()) {
            t1.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 15) {
            t1.setError("Username too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            t1.setError("White Spaces are not allowed");
            return false;
        } else {
            t1.setError(null);
            //t1.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateEmail() {
        String val = t3.getEditableText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            t3.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            t3.setError("Invalid email address");
            return false;
        } else {
            t3.setError(null);
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
        String val = t2.getText().toString();
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
            t2.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            t2.setError("Password is too weak");
            return false;
        } else {
            t2.setError(null);
            //t2.setErrorEnabled(false);
            return true;
        }
    }
    // Configure Google Sign In
    GoogleSignInOptions gso = new GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client))
            .requestEmail()
            .build();
}




//    private void SetValidation() {
//        // Check for a valid email address.
//        if (t3.getText().toString().isEmpty()) {
//            t3.setError(getResources().getString(R.string.email_eror));
//            isEmailValid = false;
//        } else if (!Patterns.EMAIL_ADDRESS.matcher(t3.getText().toString()).matches()) {
//            t3.setError(getResources().getString(R.string.error_invalid_email));
//            isEmailValid = false;
//        } else  {
//            isEmailValid = true;
//        }
//
//        // Check for a valid password.
//        if (t2.getText().toString().isEmpty()) {
//            t2.setError(getResources().getString(R.string.password_error));
//            isPasswordValid = false;
//        } else if (t2.getText().length() < 6) {
//            t2.setError(getResources().getString(R.string.error_invalid_password));
//            isPasswordValid = false;
//        } else  {
//            isPasswordValid = true;
//        }
//
//        if (isEmailValid && isPasswordValid) {
//            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//    }

