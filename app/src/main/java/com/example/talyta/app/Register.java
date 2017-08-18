package com.example.talyta.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etUsername, etEmail, etPassword;
    Button btRegister, btArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.nameRegister);
        etUsername = (EditText) findViewById(R.id.usernameRegister);
        etEmail = (EditText) findViewById(R.id.emailRegister);
        etPassword = (EditText) findViewById(R.id.passwordRegister);
        btRegister = (Button) findViewById(R.id.btRegister);
        btArrow = (Button) findViewById(R.id.btArrow);

        btRegister.setOnClickListener(this);
        btArrow.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btRegister:

                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                String newUser = etName.getText().toString();
                String newUsername = etUsername.getText().toString();
                String newPassword = etPassword.getText().toString();
                String newEmail = etEmail.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                String User = preferences.getString(newUsername + newPassword + "data", newUsername);
                editor.putString(newUser + newUsername + newPassword + "data", newUser + "\n" + newEmail);
                editor.commit();

                Intent loginScreen = new Intent(MyApp.getContext(), Login.class);
                startActivity(loginScreen);
                break;

            case R.id.btArrow:

                Intent i = new Intent(MyApp.getContext(), Login.class);
                startActivity(i);

                break;


        }
    }
}


