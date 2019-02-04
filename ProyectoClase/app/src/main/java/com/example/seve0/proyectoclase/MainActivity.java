package com.example.seve0.proyectoclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnGuardar, btnMostrar;
    private EditText nombre, musica, ciudad;
    private ClientesSQLiteHelper clientesSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientesSQLiteHelper = new ClientesSQLiteHelper(this);

        btnGuardar = (Button) findViewById(R.id.btnguardar);
        btnMostrar = (Button) findViewById(R.id.btnmostrar);
        nombre = (EditText) findViewById(R.id.etnombre);
        musica = (EditText) findViewById(R.id.etmusica);
        ciudad = (EditText) findViewById(R.id.etciudad);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clientesSQLiteHelper.addUser(nombre.getText().toString(), musica.getText().toString(), ciudad.getText().toString());
                nombre.setText("");
                musica.setText("");
                ciudad.setText("");
                Toast.makeText(MainActivity.this, "Guardado Correctamente!", Toast.LENGTH_SHORT).show();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MostrarUsuarios.class);
                startActivity(intent);
            }
        });

    }
}
