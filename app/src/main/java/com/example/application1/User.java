package com.example.application1;

import android.widget.EditText;

public class User {
    //for using User class,we need to create few string variables
    public String t1,t2,t3;
    //Now we need to create 2 constructors,1st should be empty public constructor
    public User(String email, String password){

    }
    //second string
    public User(String r1,String r2,String r3){
        this.t1=r1;
        this.t2=r2;
        this.t3=r3;
    }
}
