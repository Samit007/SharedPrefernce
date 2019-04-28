package com.e.sharedprefernce;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText etUsername, etPassword,etRePassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etPassword=findViewById(R.id.etPassword);
        etRePassword=findViewById(R.id.etRePassword);
        etUsername=findViewById(R.id.etUsername);
        btnRegister=findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass=etPassword.getText().toString();
                if (pass.equals(etRePassword.getText().toString())) {
                    SignUp();
                }else {
                    Toast.makeText(RegisterActivity.this, "wrong username or password", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void SignUp() {
        SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString("username",etUsername.getText().toString());
        editor.putString("password",etPassword.getText().toString());
        editor.commit();

        Toast.makeText(this,"Successfully registered",Toast.LENGTH_SHORT).show();
    }
}
