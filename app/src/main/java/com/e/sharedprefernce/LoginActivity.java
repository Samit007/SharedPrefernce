package com.e.sharedprefernce;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsernameLogin, etPasswordLogin;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPasswordLogin = findViewById(R.id.etPasswordLogin);
        etUsernameLogin = findViewById(R.id.etUsernameLogin);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              checkUser();
            }
        });
    }


    private void checkUser() {
        SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        String password=sharedPreferences.getString("password","");
        if(username.equals(etUsernameLogin.getText().toString())||
        password.equals(etPasswordLogin.getText().toString())){
            Toast.makeText(LoginActivity.this,"Successfull",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(LoginActivity.this,"Incorrect username or password",Toast.LENGTH_SHORT).show();

        }
    }
}