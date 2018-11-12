package com.example.tsvtsv.alquilerseve;

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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final ImageView coche = (ImageView) findViewById(R.id.image);
        final TextView marca = (TextView) findViewById(R.id.marcaCoche);
        final TextView horas = (TextView) findViewById(R.id.horas);
        final TextView deco = (TextView) findViewById(R.id.deco);
        final TextView total = (TextView) findViewById(R.id.total);

        Coches coches = (Coches) getIntent().getSerializableExtra("TODO");

        Toast.makeText(getApplicationContext(),coches.getMarca(),Toast.LENGTH_LONG);
        /*if (zonas.getMarca().equals("Megane"))
            coche.setImageDrawable(getDrawable(R.drawable.megan1));
        if (zonas.getMarca().equals("X-11"))
            coche.setImageDrawable(getDrawable(R.drawable.ferrari1));
        if (zonas.getMarca().equals("Leon"))
            coche.setImageDrawable(getDrawable(R.drawable.leon1));
        if (zonas.getMarca().equals("Fiesta"))
            coche.setImageDrawable(getDrawable(R.drawable.fiesta1));

        marca.setText(zonas.getMarca());
        horas.setText("Horas: " + getIntent().getDoubleExtra("PESO", 0));
        deco.setText("Decoración: " + getIntent().getStringExtra("DECO"));
        total.setText("Precio total del alquiler: " + String.valueOf(getIntent().getDoubleExtra("PRECIO", 0)) + "€");

        registerForContextMenu(coche);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx_image, menu);

        return true;
    }

    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx_image, menu);
    }
*/
    }
}