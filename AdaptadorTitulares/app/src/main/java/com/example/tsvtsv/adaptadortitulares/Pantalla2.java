package com.example.tsvtsv.adaptadortitulares;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tsvtsv.adaptadortitulares.R;

public class Pantalla2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView titulo = (TextView) findViewById(R.id.miTitulo);
        final TextView subtitulo = (TextView) findViewById(R.id.miSubtitulo);
        final ImageView imagen = (ImageView) findViewById(R.id.miImagen);

        //RECOGE OBJETO
        Titular titular = (Titular) getIntent().getSerializableExtra("Final");
        titulo.setText(titular.getTitulo());
        subtitulo.setText(titular.getSubtitulo());
        imagen.setBackground(getDrawable(titular.getImagen()));

        //RECOGE UNO POR UNO
        // Bundle miBundleRecoger = getIntent().getExtras();
        //titulo.setText(miBundleRecoger.getString("TEXTO1"));
        //subtitulo.setText(miBundleRecoger.getString("TEXTO2"));
        //imagen.setBackground(getDrawable(miBundleRecoger.getInt("Imagen")));


    }
}
