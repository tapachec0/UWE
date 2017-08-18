package com.example.talyta.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// Teste commit

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etPassword;
    Button btLogin;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = (EditText) findViewById(R.id.usernameLogin);
        etPassword = (EditText) findViewById(R.id.passwordLogin);
        btLogin = (Button) findViewById(R.id.btLogin);


        btLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btLogin:
                String User = etName.getText().toString();
                String Password = etPassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

                String userDetails = preferences.getString(User + Password + "data", "Username or Password is Incorrect.");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("User", user);

                if (userDetails.equals(user)){
                    Intent i = new Intent(this, Report.class);
                    startActivity(i);
                }



                break;
        }

    }
}
