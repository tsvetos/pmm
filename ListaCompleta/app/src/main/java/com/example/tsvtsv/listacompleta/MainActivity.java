package com.example.tsvtsv.listacompleta;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Titular[]datos = new Titular[]{
        new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
        new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
        new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1, int position, long id){
                String mensaje = "Titulo: " + datos[position].getTitulo() + " . Subtitulo: "+ datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG).show();
            }

        });

    }

    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView(int i, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[i].getTitulo());

            TextView lblStudio = (TextView) item.findViewById(R.id.LblSubTitulo);
            lblStudio.setText(datos[i].getSubtitulo());

            ImageView imagen = (ImageView)item.findViewById(R.id.LblImagen);
            imagen.setBackground(getDrawable(datos[i].getImagen()));

            return(item);

        }
    }
}
