package com.example.seve0.tareaenvios;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    TextView zona, tarifa, peso, decoracion, coste;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent i = getIntent();
        Bundle b = i.getExtras();

        zona = (TextView) findViewById(R.id.zona);
        tarifa = (TextView) findViewById(R.id.tarifa);
        peso = (TextView) findViewById(R.id.peso);
        decoracion = (TextView) findViewById(R.id.decoracion);
        coste = (TextView) findViewById(R.id.coste);
        img = (ImageView) findViewById(R.id.imageView);

        String z = b.getString("zona");
        zona.setText(z);
        tarifa.setText(b.getString("tarifa"));
        peso.setText(Double.toString(b.getDouble("peso")));
        decoracion.setText(b.getString("decoracion"));
        coste.setText("\n" + "\t\t\t\t" + Double.toString(b.getDouble("coste")) + "€");

       /* if(z.equals("Asia y Oceanía"))
            img.setImageDrawable(getResources().getDrawable(R.drawable.asia));
        else if(z.equals("Ámerica y África"))
            img.setImageDrawable(getResources().getDrawable(R.drawable.america));
        else
            img.setImageDrawable(getResources().getDrawable(R.drawable.europa));*/

    }
}
