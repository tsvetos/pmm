package com.example.tsvtsv.alquilercoches;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final ImageView mapa = (ImageView) findViewById(R.id.image);
        final TextView modelo = (TextView) findViewById(R.id.modelo);
        final TextView marca = (TextView) findViewById(R.id.marca);
        final TextView horas = (TextView) findViewById(R.id.horas);
        final TextView deco = (TextView) findViewById(R.id.deco);
        final TextView total = (TextView) findViewById(R.id.total);

        Coches zonas = (Coches) getIntent().getSerializableExtra("TODO");
        if (zonas.getModelo().equals("Megane"))
            mapa.setImageDrawable(getDrawable(R.drawable.megan1));
        if (zonas.getModelo().equals("X-11"))
            mapa.setImageDrawable(getDrawable(R.drawable.megan2));
        if (zonas.getModelo().equals("Leon"))
            mapa.setImageDrawable(getDrawable(R.drawable.leon1));
        if (zonas.getModelo().equals("Fiesta"))
            mapa.setImageDrawable(getDrawable(R.drawable.fiesta1));
        modelo.setText(zonas.getModelo());
        marca.setText("Modelo: " + getIntent().getStringExtra("MODELO"));
        horas.setText("Horas: " + getIntent().getDoubleExtra("HORAS", 0));
        deco.setText("Decoración: " + getIntent().getStringExtra("DECO"));
        total.setText("Precio total del alquiler " + String.valueOf(getIntent().getDoubleExtra("PRECIO", 0)) + "€");

        registerForContextMenu(mapa);
    }


}