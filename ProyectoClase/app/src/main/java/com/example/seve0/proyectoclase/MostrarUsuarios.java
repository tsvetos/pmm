package com.example.seve0.proyectoclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

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

        modUsuArrayList = clientesSQLiteHelper.getAllUsers();

        customAdapter = new CustomAdapter(this, modUsuArrayList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MostrarUsuarios.this, ActualizarEliminar.class);
                intent.putExtra("usuario", modUsuArrayList.get(position));
                startActivity(intent);
            }
        });

    }
}
