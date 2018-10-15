package com.example.tsvtsv.factorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText entrada;
    private TextView salida;
    private Button miBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


          entrada = (EditText) findViewById(R.id.miTxt);
          miBtn = (Button) findViewById(R.id.miBtn);
          salida = (TextView) findViewById(R.id.miTxtView);



          miBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {


                  Intent miIntent = new Intent (MainActivity.this, Main2Activity.class);
                  Bundle miBundle = new Bundle();
                  miBundle.putString("TEXTO", calcularOperacion());
                  miIntent.putExtras(miBundle);
                  startActivity(miIntent);

              }
          });

    }
       public String calcularOperacion(){
            String numero = entrada.getText().toString();
           int n = Integer.parseInt(numero);

           salida.append(n +"! = ");
           int res = factorial(n);
           String result = n + "! = " + Integer.toString(res);
           salida.append(res + "\n");
           return result;
        }

        public int factorial(int n){
        int res = n;
        for (int i = 2; i<n; i++){
            res*=i;
        }
        return res;
        }
}
