package com.moringaschool.bill_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText mUsername;
    private EditText mPassword;
    private MaterialButton mLoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsername =(EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mLoginButton =(MaterialButton) findViewById(R.id.loginbutton);
    }
}