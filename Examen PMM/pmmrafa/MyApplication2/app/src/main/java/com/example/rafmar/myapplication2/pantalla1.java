package com.example.rafmar.myapplication2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class pantalla1 extends AppCompatActivity {
    public MediaPlayer miMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        final EditText nombre = (EditText) findViewById(R.id.miTxt);
        final Button darSaludo = (Button) findViewById(R.id.miBtn);
        final TextView saludo = (TextView) findViewById(R.id.miLbl);

        miMusica = MediaPlayer.create(getApplicationContext(), R.raw.quack);
        miMusica.start();

        darSaludo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String mensajePaso= "Te saludo " + nombre.getText().toString();

                saludo.setText(mensajePaso);

                Intent miIntent = new Intent(pantalla1.this, pantalla2.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });

        Toast.makeText(this, " esto es un TOAST", Toast.LENGTH_SHORT).show();
        //dialog
        new AlertDialog.Builder(this).setMessage("el texto").setPositiveButton(android.R.string.ok, null).show();
    }

    @Override protected void onStart() {
        super.onStart();
        Toast.makeText(this, "A1: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onResume() {
        super.onResume();
        Toast.makeText(this, "A1: onResume", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onPause() {
        Toast.makeText(this, "A1: onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
        miMusica.stop();
    }

    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(this, "A1: onStop", Toast.LENGTH_SHORT).show();
    }
}
