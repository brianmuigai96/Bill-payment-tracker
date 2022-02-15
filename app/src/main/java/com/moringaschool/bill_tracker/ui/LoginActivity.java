package com.moringaschool.bill_tracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.bill_tracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener {
    @BindView(R.id.registerTextView) TextView mRegisterTextView;
    @BindView(R.id.emailEditText) EditText mEmail;
    @BindView(R.id.registerTextView) EditText mPassword;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        mRegisterTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mRegisterTextView) {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }
    }
}