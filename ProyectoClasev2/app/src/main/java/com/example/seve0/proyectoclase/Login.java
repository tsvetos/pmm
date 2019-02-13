package com.example.seve0.proyectoclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Pantalla de login. Actualmente simplemente redirige a la pantalla principal cuando se aporta un
 * usuario y contraseña cualesquiera.
 */
public class Login extends AppCompatActivity {

    private Button btnGo;
    private EditText user, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnGo = (Button) findViewById(R.id.button);
        user = (EditText) findViewById(R.id.editTextUser);
        password = (EditText) findViewById(R.id.editTextPassword);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us = user.getText().toString();
                String pw = password.getText().toString();
                if(!us.equals("") && !us.equals("")){
                    Intent intent = new Intent(Login.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }


}
