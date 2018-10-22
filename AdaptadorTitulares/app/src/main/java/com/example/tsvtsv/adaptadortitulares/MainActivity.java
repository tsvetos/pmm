package com.example.tsvtsv.adaptadortitulares;

import android.app.Activity;
import android.content.Intent;
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
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1),
            new Titular("Titulo1","Subtitulo largo1",R.drawable.img1),
            new Titular("Titulo2","Subtitulo largo 2", R.drawable.img1),
            new Titular("Titulo3","Subtitulo largo 3", R.drawable.img1)
    };

    Titular tit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1, int position, long id){
                //String mensaje = "Titulo: " + datos[position].getTitulo() + " . Subtitulo: "+ datos[position].getSubtitulo();
                //Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG).show();

                tit = new Titular(datos[position].getTitulo(),datos[position].getSubtitulo(),datos[position].getImagen());
                Intent mio= new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                // miBundle.putString("TEXTO1",  datos[position].getTitulo());
                //miBundle.putString("TEXTO2",  datos[position].getSubtitulo());
                //miBundle.putInt("Imagen",  datos[position].getImagen());

                miBundle.putSerializable("Final",tit);
                mio.putExtras(miBundle);
                startActivity(mio);
            }

        });

    }

    static class ViewHolder{
        TextView lblTitulo;
        TextView lblSubtitulo;
        ImageView lblImagen;
    }

    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView(int i, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;
            if(item == null)
            { LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_titular, null);

                holder = new ViewHolder();
                holder.lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
                holder.lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
                holder.lblImagen = (ImageView)item.findViewById(R.id.LblImagen);

                item.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)item.getTag(); }
            holder.lblTitulo.setText(datos[i].getTitulo());
            holder.lblSubtitulo.setText(datos[i].getSubtitulo());
            holder.lblImagen.setBackground(getDrawable(datos[i].getImagen()));
            return(item);
        }
    }
}
