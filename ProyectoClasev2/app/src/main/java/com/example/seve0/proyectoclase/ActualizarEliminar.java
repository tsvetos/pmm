package com.example.seve0.proyectoclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Actividad para la actualización o borrado de entradas de la base de datos.
 */

public class ActualizarEliminar extends AppCompatActivity {

    private ModeloUsuario modUsuario;
    private EditText etnombre, etmusica, etciudad;
    private Button btnupdate, btndelete;
    private ClientesSQLiteHelper clientesSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_eliminar);

        //Obtención del usuario a modificar
        Intent intent = getIntent();
        modUsuario = (ModeloUsuario) intent.getSerializableExtra("usuario");

        clientesSQLiteHelper = new ClientesSQLiteHelper(this);

        etnombre = (EditText) findViewById(R.id.etname);
        etmusica = (EditText) findViewById(R.id.etmusica);
        etciudad = (EditText) findViewById(R.id.etcity);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);

        etnombre.setText(modUsuario.getName());
        etmusica.setText(modUsuario.getMusica());
        etciudad.setText(modUsuario.getCity());

        btnupdate.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener para los clicks en el botón de actualizar, muestra un Toast tras la
             * actualización y devuelve al usuario a la pantalla principal de la aplicación
             * @param v Botón pulsado
             */
            @Override
            public void onClick(View v) {
                clientesSQLiteHelper.updateUser(modUsuario.getId(), etnombre.getText().toString(), etmusica.getText().toString(), etciudad.getText().toString());
                Toast.makeText(ActualizarEliminar.this, "Actualizado Correctamente!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ActualizarEliminar.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener para los clicks en el botón de eliminar. Muestra un Toast tras la
             * eliminación y devuelve al usuario a la pantalla principal de la aplicación
             * @param v Botón pulsado
             */
            @Override
            public void onClick(View v) {
                clientesSQLiteHelper.deleteUSer(modUsuario.getId());
                Toast.makeText(ActualizarEliminar.this, "Eliminado Correctamente!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ActualizarEliminar.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
