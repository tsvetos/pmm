package com.example.tsvtsv.alquilercoches;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int precioExtras;
    private static double precioHoras;
    private static EditText horas;
    private static RadioButton sinseguro;
    private static RadioButton conseguro;
    private static TextView eleccion;
    private static CheckBox aire;
    private static CheckBox gps;
    private static CheckBox radio;
    private double total;
    private Coches coche;

    private Coches[] datos = new Coches[] {
            new Coches (0, "Megane", "Seat", "20€"),
            new Coches (1, "X-11", "Ferrari", "100€"),
            new Coches (2, "Leon", "Seat", "30€"),
            new Coches (3, "Fiesta", "Ford", "40€")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorZonas adaptador = new AdaptadorZonas(this);
        ListView lstOpciones = (ListView) findViewById(R.id.opciones);
        lstOpciones.setAdapter(adaptador);
        eleccion = (TextView) findViewById(R.id.eleccion);



        horas = (EditText) findViewById(R.id.horas);

        conseguro = (RadioButton) findViewById(R.id.normal);
        conseguro.toggle();

        sinseguro = (RadioButton) findViewById(R.id.sinseguro);

        aire = (CheckBox) findViewById(R.id.aire);

        gps = (CheckBox) findViewById(R.id.gps);

        radio = (CheckBox) findViewById(R.id.radioDVD);
    }

    public void calcular (View view) {
        Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);



        total = precioHoras + precioExtras;

        if (conseguro.isChecked())
            total *= 1.2;

        Bundle miBundle = new Bundle();
        miBundle.putSerializable("TODO", coche);
        if (!conseguro.isChecked())
            miBundle.putString("TARIFA", "Sin Seguro");
        else
            miBundle.putString("TARIFA", "Con seguro");
        miBundle.putDouble("PESO", Double.valueOf(horas.getText().toString()));

        if (aire.isChecked() && !gps.isChecked() && !radio.isChecked())
            miBundle.putString("DECO", "Caja Regalo");
        else if (!aire.isChecked() && gps.isChecked()  && !radio.isChecked())
            miBundle.putString("DECO", "Tarjeta Dedicada");
        else if (!aire.isChecked() && !gps.isChecked()  && radio.isChecked())
            miBundle.putString("DECO", "Tarjeta Dedicada");
        else if (aire.isChecked() && gps.isChecked() && radio.isChecked())
            miBundle.putString("DECO", "Aire acondicionado, GPS y radio/dvd");

        miBundle.putDouble("PRECIO", total);
        miIntent.putExtras(miBundle);
        startActivity(miIntent);
    }

    static class ViewHolder {
        TextView modelo;
        TextView marca;
        TextView precio;
    }

    class AdaptadorZonas extends ArrayAdapter {
        Activity context;

        AdaptadorZonas(Activity context) {
            super(context, R.layout.linear_text_view, datos);
            this.context = context;
        }

        public View getView (int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;

            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.linear_text_view, null);
                holder = new ViewHolder();
                holder.modelo = (TextView) item.findViewById(R.id.modelo);
                holder.marca = (TextView) item.findViewById(R.id.marca);
                holder.precio = (TextView) item.findViewById(R.id.precio);

                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.modelo.setText(datos[position].getFabricante());

            holder.marca.setText(datos[position].getModelo());

            holder.precio.setText(datos[position].getPrecio());

            return (item);
        }
    }
}
