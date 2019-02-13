package com.example.seve0.proyectoclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Pantalla principal de la aplicación. En ella se desarrolla la introducción de nuevas entradas a
 * la base de datos, así como la navegación a las otras pantallas
 */
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
            /**
             * Guarda una entrada con los valores encontrados en los editText. Si hay algún campo
             * vacío, avisa al usuario mediante un toast, y si los datos son correctos, se vacían
             * los campos y se avisa al usuario mediante un toast.
             * @param v Botón clicado
             */
            @Override
            public void onClick(View v) {
                String nm,mu,ct;
                nm = nombre.getText().toString();
                mu = musica.getText().toString();
                ct = ciudad.getText().toString();

                if(!nm.equals("") && !mu.equals("") && !ct.equals("")) {
                    clientesSQLiteHelper.addUser(nombre.getText().toString(), musica.getText().toString(), ciudad.getText().toString());
                    nombre.setText("");
                    musica.setText("");
                    ciudad.setText("");
                    Toast.makeText(MainActivity.this, "Guardado Correctamente!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Revise los campos de texto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            /**
             * Lleva al usuario a la pantalla que muestra todas las entradas de la BBDD
             * @param v Botón clicado
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MostrarUsuarios.class);
                startActivity(intent);
            }
        });

    }
}
