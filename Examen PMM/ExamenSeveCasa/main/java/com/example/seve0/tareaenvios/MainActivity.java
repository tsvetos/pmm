package com.example.seve0.tareaenvios;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText pesoBox;
    RadioGroup radioGroup;
    Button button;
    CheckBox regalo, tarjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        pesoBox = (EditText) findViewById(R.id.editText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.button);
        regalo = (CheckBox) findViewById(R.id.regaloBox);
        tarjeta = (CheckBox) findViewById(R.id.tarjetaCheck);

        Destino DestA = new Destino(1), DestB = new Destino(2), DestC = new Destino(3);


        List<Destino> destinoList = new ArrayList<>();
        destinoList.add(DestA);
        destinoList.add(DestB);
        destinoList.add(DestC);

        ArrayAdapter<Destino> adapter = new ArrayAdapter<Destino>(this,android.R.layout.simple_spinner_item,destinoList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void calcPrecio(View v){
        double tarifa1 = 1, precio = 0, peso = 1, tarifa2 = 1;
        String t,d = "";
        Destino destino = (Destino) spinner.getSelectedItem();
        peso = Double.parseDouble(pesoBox.getText().toString());
        if(peso>10)
            tarifa1 = 2;
        else if (peso>5)
            tarifa1 = 1.5;
        if(radioGroup.getCheckedRadioButtonId() == R.id.urgente)
            tarifa2 += 0.3;

        precio = (destino.getPrecio()+peso*tarifa1)*tarifa2;

        Intent i = new Intent(this, Results.class);
        i.putExtra("zona", destino.getContinente());
        if(tarifa2 == 1.3)
            t = "Normal";
        else
            t = "Urgente";
        i.putExtra("tarifa", t);
        i.putExtra("peso",peso);
        if (regalo.isChecked())
            d = "Caja regalo. ";
        if (tarjeta.isChecked())
            d = d+"Tarjeta dedicada.";
        i.putExtra("decoracion", d);
        i.putExtra("coste", precio);
        startActivity(i);




    }
}
