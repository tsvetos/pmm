package com.example.tsvtsv.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    public static int COD_RESPUESTA=0;
    TextView elSaludo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        TextView textView1 = (TextView) findViewById(R.id.miMensaje);
        ImageButton imageButton = (ImageButton) findViewById(R.id.miBtn);

        Bundle myBundle = getIntent().getExtras();
        textView1.setText(myBundle.getString("1st message"));

        ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
