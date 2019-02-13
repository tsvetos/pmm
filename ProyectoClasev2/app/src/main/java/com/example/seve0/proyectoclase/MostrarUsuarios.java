package com.example.seve0.proyectoclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Actividad que muestra los usuarios y permite hacer clic en ellos para su modificación/actualización
 */
public class MostrarUsuarios extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ModeloUsuario> modUsuArrayList;
    private CustomAdapter customAdapter;
    private ClientesSQLiteHelper clientesSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuarios);

        listView = (ListView) findViewById(R.id.lv);

        clientesSQLiteHelper = new ClientesSQLiteHelper(this);

        // Obtiene todos los usuarios de la base de datos para mostrarlos en el listView
        modUsuArrayList = clientesSQLiteHelper.getAllUsers();

        customAdapter = new CustomAdapter(this, modUsuArrayList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Método ejecutado al tocar en uno de los objetos de la base de datos. Llama a la
             * actividad ActualizarEliminar.java y envía el usuario clicado en el intent.
             * @param parent el AdapterView donde ha ocurrido el click
             * @param view la vista del AdapterView clicado
             * @param position posición del AdapterView en la lista
             * @param id id de la fila clicada
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MostrarUsuarios.this, ActualizarEliminar.class);
                intent.putExtra("usuario", modUsuArrayList.get(position));
                startActivity(intent);
            }
        });

    }
}
