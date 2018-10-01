package com.example.tsvtsv.componentesbasicos;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 /*       chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        txtHobby = (TextView)findViewById(R.id.txtHobby);

        chkBoxCycling.setOnCheckedChangeListener(new Mia());
        chkBoxTeaching.setOnCheckedChangeListener(new Mia());
        chkBoxBlogging.setOnCheckedChangeListener(new Mia());
*/
        final TextView lblMensaje = (TextView) findViewById(R.id.LblSeleccion);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);
        final RadioButton red = (RadioButton)findViewById(R.id.radio1);
        final RadioButton blue = (RadioButton)findViewById(R.id.radio2);
      //  rg.clearCheck();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                lblMensaje.setText("Opcion seleccionada: " + checkedId);

                if(red.isChecked())
                    lblMensaje.setTextColor(Color.RED);
                if(blue.isChecked())
                    lblMensaje.setTextColor(Color.BLUE);




              /* Mejora el texto informativo
                String textoOpcion="";
                if( group.getCheckedRadioButtonId()==R.id.radio1)...... */
            }
        });


    } //onCreate


   /* class Mia implements CheckBox.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String mensaje ="";
            if(isChecked) {
                if (buttonView == chkBoxCycling) {
                    mensaje += "Cycling";
                }
                if (buttonView == chkBoxTeaching) {
                    mensaje += "Teaching";
                }
                if (buttonView == chkBoxBlogging) {
                    mensaje += "Blogging";
                }
            }
            txtHobby.setText(mensaje);
        }
    }*/
}



        /* chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        btnHobby = (Button) findViewById(R.id.btnHobby);
        txtHobby = (TextView) findViewById(R.id.txtHobby);
*/
        /*final TextView lblMensaje = (TextView) findViewById(R.id.LblSeleccion);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);
        rg.clearCheck();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String textoOpcion="";
                if( group.getCheckedRadioButtonId()==R.id.radio1)
                    textoOpcion +="OPCION 1 con ID:" + checkedId;
                if( group.getCheckedRadioButtonId()==R.id.radio2)
                    textoOpcion +="OPCION 2 con ID:" + checkedId ;
                lblMensaje.setText(textoOpcion);
            }
        });*/



       /* btnHobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHobbyClick(v);
            }
        });
    }
    public void getHobbyClick ( View v){
        {
            String strMessage = "";
            if(chkBoxCycling.isChecked())
            {
                strMessage = "pedalear";
            }
            if(chkBoxTeaching.isChecked())
            {
                strMessage ="enseñar ";
            }
            if(chkBoxBlogging.isChecked())
            {
                strMessage ="blogear ";
            }
            txtHobby.setText(strMessage);
        }

    }*/







