package com.example.tsvtsv.androidmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView lblMensaje;
    private ImageView lblImage;
    private View lblView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblMensaje = (TextView) findViewById(R.id.miTxt);
        lblImage = (ImageView) findViewById(R.id.lblImage);
        lblView = (View) findViewById(R.id.drawing_area);

        registerForContextMenu(lblImage);
        registerForContextMenu(lblView);


    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje.setText("Opcion 1 pulsada");
                return  true;
            case R.id.MnuOpc2:
                lblMensaje.setText("Opcion 2 pulsada");
                return  true;
            case R.id.MnuOpc3:
                lblMensaje.setText("Opcion 3 pulsada");
                return  true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje.setText("Opcion 1 pulsada");
                return true;
            case R.id.MnuOpc2:
                lblMensaje.setText("Opcion 2 pulsada");
                return true;
            case R.id.MnuOpc3:
                lblMensaje.setText("Opcion 3 pulsada");
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}