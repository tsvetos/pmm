package com.example.seve0.botoneslayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LayoutTabla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tabla);

        final Button botonVolver = (Button) findViewById(R.id.botonVolver);

        botonVolver.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(LayoutTabla.this, MainActivity.class);
                Bundle miBundle=new Bundle();
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });


    }
}
