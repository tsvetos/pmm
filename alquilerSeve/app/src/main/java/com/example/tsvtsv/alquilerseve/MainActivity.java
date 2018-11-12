package com.example.tsvtsv.alquilerseve;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static int precioExtras;
    private static double precioKilo;
    private static EditText horas;
    private static RadioButton sinseguro;
    private static RadioButton conseguro;
    private static TextView eleccion;
    private static CheckBox aire;
    private static CheckBox gps;
    private static CheckBox radioDVD;
    private double total;
    private Coches coche;

    private Coches[] datos = new Coches[] {
            new Coches (0, "Megane", "Seat", "20€",R.drawable.megan1),
            new Coches (1, "X-11", "Ferrari", "100€",R.drawable.ferrari1),
            new Coches (2, "Leon", "Seat", "30€",R.drawable.leon1),
            new Coches (3, "Fiesta", "Ford", "40€",R.drawable.fiesta1)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), PantallaDibujo.class);
                startActivityForResult(intent, 0);
            }
        });


        AdaptadorCoches adaptador = new AdaptadorCoches(this);
        ListView lstOpciones = (ListView) findViewById(R.id.opciones);
        lstOpciones.setAdapter(adaptador);
        eleccion = (TextView) findViewById(R.id.eleccion);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick (AdapterView arg0, View arg1, int position, long id) {
                if (position == 0) {
                    precioExtras = 30;

                }
                if (position == 1) {
                    precioExtras = 20;

                }
                if (position == 2) {
                    precioExtras = 10;

                }
                eleccion.setText("Coche elegido: " + datos[position].getModelo());

                coche = new Coches(datos[position].getId(), datos[position].getModelo(), datos[position].getMarca(), datos[position].getPrecio(),
                        datos[position].getImagen());
            }
        });

        horas = (EditText) findViewById(R.id.horas);

        sinseguro = (RadioButton) findViewById(R.id.sinseguro);
        sinseguro.toggle();

        conseguro = (RadioButton) findViewById(R.id.conseguro);

        aire = (CheckBox) findViewById(R.id.aireacc);

        gps = (CheckBox) findViewById(R.id.gps);

        radioDVD = (CheckBox) findViewById(R.id.radiodvd);
    }

    public void calcular (View view) {
        Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);

        if (aire.isChecked())
            precioExtras += 50;
        if(gps.isChecked())
            precioExtras += 50;
        if (radioDVD.isChecked())
            precioExtras += 50;

        total += precioExtras;

        total = precioKilo + precioExtras;

        if (conseguro.isChecked())
            total *= 1.2;


        Bundle miBundle = new Bundle();
        miBundle.putSerializable("TODO", coche);
        if (!conseguro.isChecked())
            miBundle.putString("TARIFA", "Normal");
        else
            miBundle.putString("TARIFA", "Urgente");
        miBundle.putDouble("PESO", Double.valueOf(horas.getText().toString()));

        if (aire.isChecked() && !gps.isChecked() && !radioDVD.isChecked())
            miBundle.putString("DECO", "Aire acondicionado");
        else if (!aire.isChecked() && gps.isChecked() && !radioDVD.isChecked())
            miBundle.putString("DECO", "Gps");
        else if (!aire.isChecked() && !gps.isChecked() && radioDVD.isChecked())
            miBundle.putString("DECO", "Radio dvd");

        miBundle.putDouble("PRECIO", total);
        miIntent.putExtras(miBundle);
        startActivity(miIntent);
    }

    static class ViewHolder {
        TextView zona;
        TextView pais;
        TextView precio;
        ImageView imagen;
    }

    class AdaptadorCoches extends ArrayAdapter {
        Activity context;

        AdaptadorCoches(Activity context) {
            super(context, R.layout.linear_text_view, datos);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView (int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;

            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.linear_text_view, null);
                holder = new ViewHolder();
                holder.zona = (TextView) item.findViewById(R.id.zona);
                holder.pais = (TextView) item.findViewById(R.id.pais);
                holder.precio = (TextView) item.findViewById(R.id.precio);
                holder.imagen = (ImageView) item.findViewById(R.id.imagen);

                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.zona.setText(datos[position].getModelo());

            holder.pais.setText(datos[position].getMarca());

            holder.precio.setText(datos[position].getPrecio());

            holder.imagen.setBackground(getDrawable(datos[position].getImagen()));

            return (item);
        }
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
}